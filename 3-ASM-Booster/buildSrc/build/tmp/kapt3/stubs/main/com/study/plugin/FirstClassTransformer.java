package com.study.plugin;

import java.lang.System;

@com.google.auto.service.AutoService(value = {com.didiglobal.booster.transform.asm.ClassTransformer.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/study/plugin/FirstClassTransformer;", "Lcom/didiglobal/booster/transform/asm/ClassTransformer;", "()V", "transform", "Lorg/objectweb/asm/tree/ClassNode;", "context", "Lcom/didiglobal/booster/transform/TransformContext;", "klass", "buildSrc"})
public final class FirstClassTransformer implements com.didiglobal.booster.transform.asm.ClassTransformer {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.objectweb.asm.tree.ClassNode transform(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext context, @org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.ClassNode klass) {
        return null;
    }
    
    public FirstClassTransformer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.io.File getReport(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext context, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.io.File getReportDir(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext context) {
        return null;
    }
    
    @java.lang.Override()
    public void onPostTransform(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext context) {
    }
    
    @java.lang.Override()
    public void onPreTransform(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext context) {
    }
}