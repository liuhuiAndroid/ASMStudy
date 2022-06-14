package com.study.plugin.transform

import com.didiglobal.booster.transform.TransformContext
import com.didiglobal.booster.transform.asm.ClassTransformer
import com.didiglobal.booster.transform.asm.asIterable
import com.didiglobal.booster.transform.asm.className
import com.google.auto.service.AutoService
import com.study.plugin.*
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.*

@AutoService(ClassTransformer::class)
class TimeCostTransform : ClassTransformer {

    override fun transform(context: TransformContext, klass: ClassNode): ClassNode {
        val enterMethodName = "com.study.test.MainActivity.onCreate"
        val className = klass.className
        klass.methods.filter { methodNode ->
            methodNode.name != "<init>" &&
                    !methodNode.isEmptyMethod() &&
                    !methodNode.isSingleMethod() &&
                    !methodNode.isGetSetMethod() &&
                    !methodNode.isMainMethod(className)
        }.forEach { methodNode ->
            val allMethodName = "${klass.className}.${methodNode.name}"
            if (allMethodName == enterMethodName) {
                "TimeCostTransform ${context.projectDir.lastPath()}-> matched enterMethod===>$allMethodName".println()
                methodNode.instructions.asIterable()
                    .filterIsInstance(MethodInsnNode::class.java).let { methodInsnNodes ->
                        if (methodInsnNodes.isNotEmpty()) {
                            //方法入口插入
                            methodNode.instructions.insert(
                                createMethodEnterInsnList(
                                    className,
                                    methodNode.name,
                                    methodNode.access
                                )
                            )
                            //方法出口插入
                            methodNode.instructions.getMethodExitInsnNodes()
                                ?.forEach { methodExitInsnNode ->
                                    methodNode.instructions.insertBefore(
                                        methodExitInsnNode,
                                        createMethodExitInsnList(
                                            className,
                                            methodNode.name,
                                            methodNode.access
                                        )
                                    )
                                }
                        }
                    }
            }
        }
        return klass
    }


    /**
     * 创建慢函数入口指令集
     */
    private fun createMethodEnterInsnList(
        className: String,
        methodName: String,
        access: Int
    ): InsnList {
        val isStaticMethod = access and ACC_STATIC != 0
        return with(InsnList()) {
            if (isStaticMethod) {
                add(
                    FieldInsnNode(
                        GETSTATIC,
                        "com/study/test/MethodCostUtil",
                        "INSTANCE",
                        "Lcom/study/test/MethodCostUtil;"
                    )
                )
                add(IntInsnNode(SIPUSH, 5))
                add(LdcInsnNode("$className&$methodName"))
                add(
                    MethodInsnNode(
                        INVOKEVIRTUAL,
                        "com/study/test/MethodCostUtil",
                        "recodeStaticMethodCostStart",
                        "(ILjava/lang/String;)V",
                        false
                    )
                )
            } else {
                add(
                    FieldInsnNode(
                        GETSTATIC,
                        "com/study/test/MethodCostUtil",
                        "INSTANCE",
                        "Lcom/study/test/MethodCostUtil;"
                    )
                )
                add(IntInsnNode(SIPUSH, 5))
                add(LdcInsnNode("$className&$methodName"))
                add(VarInsnNode(ALOAD, 0))
                add(
                    MethodInsnNode(
                        INVOKEVIRTUAL,
                        "com/study/test/MethodCostUtil",
                        "recodeObjectMethodCostStart",
                        "(ILjava/lang/String;Ljava/lang/Object;)V",
                        false
                    )
                )
            }

            this
        }

    }


    /**
     * 创建慢函数退出时的指令集
     */
    private fun createMethodExitInsnList(
        className: String,
        methodName: String,
        access: Int
    ): InsnList {
        val isStaticMethod = access and ACC_STATIC != 0
        return with(InsnList()) {
            if (isStaticMethod) {
                add(
                    FieldInsnNode(
                        GETSTATIC,
                        "com/study/test/MethodCostUtil",
                        "INSTANCE",
                        "Lcom/study/test/MethodCostUtil;"
                    )
                )
                add(IntInsnNode(SIPUSH, 5))
                add(LdcInsnNode("$className&$methodName"))
                add(
                    MethodInsnNode(
                        INVOKEVIRTUAL,
                        "com/study/test/MethodCostUtil",
                        "recodeStaticMethodCostEnd",
                        "(ILjava/lang/String;)V",
                        false
                    )
                )
            } else {
                add(
                    FieldInsnNode(
                        GETSTATIC,
                        "com/study/test/MethodCostUtil",
                        "INSTANCE",
                        "Lcom/study/test/MethodCostUtil;"
                    )
                )
                add(IntInsnNode(SIPUSH, 5))
                add(LdcInsnNode("$className&$methodName"))
                add(VarInsnNode(ALOAD, 0))
                add(
                    MethodInsnNode(
                        INVOKEVIRTUAL,
                        "com/study/test/MethodCostUtil",
                        "recodeObjectMethodCostEnd",
                        "(ILjava/lang/String;Ljava/lang/Object;)V",
                        false
                    )
                )
            }
            this
        }
    }

}