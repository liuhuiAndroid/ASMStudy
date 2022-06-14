package com.study.plugin

import com.android.build.gradle.api.BaseVariant
import com.didiglobal.booster.gradle.project
import com.didiglobal.booster.task.spi.VariantProcessor
import com.google.auto.service.AutoService
import org.gradle.api.Project

@AutoService(VariantProcessor::class)
class SimpleVariantProcessor(project: Project) : VariantProcessor {

    init {
        println("${project.name}")
    }

    override fun process(variant: BaseVariant) {
        println("${variant.project.name}: ${variant.name}")
    }

}