package com.zj.asm.timecost

import com.android.build.api.instrumentation.*
import org.objectweb.asm.ClassVisitor

/**
 * 直接使用 Transform Action 的话还是有些麻烦
 * AGP 很贴心的为我们又做了一层封装，提供了 AsmClassVisitorFactory 来方便我们使用 Transform Action 进行ASM操作。
 * 根据官方的说法，AsmClassVisitoFactory会带来约18%的性能提升，同时可以减少约5倍代码。
 */
abstract class TimeCostTransform : AsmClassVisitorFactory<InstrumentationParameters.None> {

    /**
     * 返回我们自定义的 ClassVisitor
     * 在自定义Visitor处理完成后，需要传内容传递给下一个Visitor，因此我们将其放在构造函数中传入
     */
    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return TimeCostClassVisitor(nextClassVisitor, classContext.currentClassData.className)
    }

    /**
     * 用于控制我们的自定义 Visitor 是否需要处理这个类，通过这个方法可以过滤我们不需要的类，加快编译速度。
     */
    override fun isInstrumentable(classData: ClassData): Boolean {
        return (classData.className.contains("com.zj.android_asm"))
    }
}
