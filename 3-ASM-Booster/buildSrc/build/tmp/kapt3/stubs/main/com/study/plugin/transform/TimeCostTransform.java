package com.study.plugin.transform;

import java.lang.System;

@com.google.auto.service.AutoService(value = {com.didiglobal.booster.transform.asm.ClassTransformer.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/study/plugin/transform/TimeCostTransform;", "Lcom/didiglobal/booster/transform/asm/ClassTransformer;", "()V", "createMethodEnterInsnList", "Lorg/objectweb/asm/tree/InsnList;", "className", "", "methodName", "access", "", "createMethodExitInsnList", "transform", "Lorg/objectweb/asm/tree/ClassNode;", "context", "Lcom/didiglobal/booster/transform/TransformContext;", "klass", "buildSrc"})
public final class TimeCostTransform implements com.didiglobal.booster.transform.asm.ClassTransformer {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.objectweb.asm.tree.ClassNode transform(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext context, @org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.ClassNode klass) {
        return null;
    }
    
    /**
     * 创建慢函数入口指令集
     */
    private final org.objectweb.asm.tree.InsnList createMethodEnterInsnList(java.lang.String className, java.lang.String methodName, int access) {
        return null;
    }
    
    /**
     * 创建慢函数退出时的指令集
     */
    private final org.objectweb.asm.tree.InsnList createMethodExitInsnList(java.lang.String className, java.lang.String methodName, int access) {
        return null;
    }
    
    public TimeCostTransform() {
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