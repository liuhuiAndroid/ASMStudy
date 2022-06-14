package com.study.plugin

import com.didiglobal.booster.transform.TransformContext
import com.didiglobal.booster.transform.asm.ClassTransformer
import com.google.auto.service.AutoService
import org.objectweb.asm.tree.ClassNode

@AutoService(ClassTransformer::class)
class FirstClassTransformer : ClassTransformer {

    override fun transform(context: TransformContext, klass: ClassNode): ClassNode {
        println("FirstClassTransformer Transforming ${klass.name}")
        return klass
    }
}