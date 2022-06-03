package com.study.asm;

import org.junit.Test;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestUnitTest {

    @Test
    public void test() throws Exception {
        // 读取.class文件
        FileInputStream fis = new FileInputStream("src/test/java/com/study/asm/Test.class");
        // class 分析器
        ClassReader cr = new ClassReader(fis);
        // ClassWriter.COMPUTE_FRAMES 意思是：自动计算栈帧和局部变量表等额外数据
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        // 调用 accept 方法执行分析，边分析边修改字节码
        cr.accept(new MyClassVisitor(Opcodes.ASM9, cw), ClassReader.EXPAND_FRAMES);
        // 执行插桩之后的字节码数据
        byte[] bytes = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream("src/test/java/com/study/asm/Test2.class");
        fos.write(bytes);
        fos.close();
    }

    // 访问者模式，只能接收方法申明
    class MyClassVisitor extends ClassVisitor {

        public MyClassVisitor(int api, ClassVisitor classVisitor) {
            super(api, classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            System.out.println("visitMethod:" + name);
            MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
            return new MyMethodVisitor(api, methodVisitor, access, name, descriptor);
        }

    }

    // MethodVisitor 才可以处理方法体
    // 不直接继承MethodVisitor，对父类进行了增强
    class MyMethodVisitor extends AdviceAdapter {

        /**
         * Constructs a new {@link AdviceAdapter}.
         *
         * @param api           the ASM API version implemented by this visitor. Must be one of {@link
         *                      Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
         * @param methodVisitor the method visitor to which this adapter delegates calls.
         * @param access        the method's access flags (see {@link Opcodes}).
         * @param name          the method's name.
         * @param descriptor    the method's descriptor (see {@link Type Type}).
         */
        protected MyMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
            super(api, methodVisitor, access, name, descriptor);
        }

        boolean inject = false;
        @Override
        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
            System.out.println("visitAnnotation:" + descriptor);
            if("Lcom/study/asm/Test$ASMTest".equals(descriptor)){
                inject = true;
            } else {
                inject = false;
            }
            return super.visitAnnotation(descriptor, visible);
        }

        int s;

        @Override
        protected void onMethodEnter() {
            super.onMethodEnter();
            if(inject) {
                // 插入 long l = System.currentTimeMillis();
                // 注意添加方法签名
                invokeStatic(Type.getType("L/java/lang/System;"), new Method("currentTimeMillis", "()J"));
                // 创建一个本地变量索引
                s = newLocal(Type.LONG_TYPE);
                // 用一个本地变量接收上一步执行的结果
                storeLocal(s);
            }
        }

        @Override
        protected void onMethodExit(int opcode) {
            super.onMethodExit(opcode);
            if(inject) {
                // 插入 long s = System.currentTimeMillis();
                // 注意添加方法签名
                invokeStatic(Type.getType("L/java/lang/System;"), new Method("currentTimeMillis", "()J"));
                // 创建一个本地变量索引
                int e = newLocal(Type.LONG_TYPE);
                // 用一个本地变量接收上一步执行的结果
                storeLocal(e);

                // 插入 System.out.println("execute:" + (s - l) + "ms.");
                getStatic(Type.getType("L/java/lang/System;"), "out", Type.getType("L/java/io/PrintStream;"));
                newInstance(Type.getType("L/java/lang/StringBuilder;"));
                dup();
                invokeConstructor(Type.getType("L/java/lang/StringBuilder;"), new Method("<init>", "()V"));
                visitLdcInsn("execute:");
                invokeVirtual(Type.getType("L/java/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder"));
                // 时间减法
                loadLocal(e);
                loadLocal(s);
                math(SUB, Type.LONG_TYPE);
                invokeVirtual(Type.getType("L/java/lang/StringBuilder;"), new Method("append", "(J)Ljava/lang/StringBuilder"));
                visitLdcInsn("ms.");
                invokeVirtual(Type.getType("L/java/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder"));
                invokeVirtual(Type.getType("L/java/lang/StringBuilder;"), new Method("toString", "()Ljava/lang/String"));
                invokeVirtual(Type.getType("L/java/io/PrintStream;"), new Method("println", "(Ljava/lang/String;)V"));
            }
        }
    }
}
