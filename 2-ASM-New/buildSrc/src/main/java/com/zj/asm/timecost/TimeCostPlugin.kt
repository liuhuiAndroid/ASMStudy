package com.zj.asm.timecost

import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class TimeCostPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // 在 AndroidComponentsExtension 中注册 Transform
        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.onVariants { variant ->
            // transformClassesWith 通过 InstrumentationScope 控制是否需要扫描依赖库代码。
            variant.instrumentation.transformClassesWith(
                TimeCostTransform::class.java,
                InstrumentationScope.PROJECT
            ) {

            }
            // setAsmFramesComputationMode 可设置不同的栈帧计算模式，具体可查看源码
            variant.instrumentation.setAsmFramesComputationMode(
                FramesComputationMode.COMPUTE_FRAMES_FOR_INSTRUMENTED_METHODS
            )
        }
    }
}