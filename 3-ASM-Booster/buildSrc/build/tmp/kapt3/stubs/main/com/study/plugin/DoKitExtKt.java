package com.study.plugin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0000\u001a(\u0010\u000e\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011\u001a>\u0010\u000e\u001a\u00020\u000f*\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00112\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011\u001a>\u0010\u000e\u001a\u00020\u000f*\u00020\u00132\u0006\u0010\f\u001a\u00020\u00172\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00112\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011\u001a\u0012\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019*\u00020\u001b\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u001e\u001a\n\u0010\u001f\u001a\u00020\u001d*\u00020\u001e\u001a\u0012\u0010 \u001a\u00020\u001d*\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001\u001a\n\u0010\"\u001a\u00020\u001d*\u00020#\u001a\n\u0010\"\u001a\u00020\u001d*\u00020$\u001a\n\u0010%\u001a\u00020\u001d*\u00020\u001e\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\'\u001a\u00020\u000f*\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006("}, d2 = {"formatSuperName", "", "Lorg/objectweb/asm/tree/ClassNode;", "getFormatSuperName", "(Lorg/objectweb/asm/tree/ClassNode;)Ljava/lang/String;", "ownerClassName", "Lorg/objectweb/asm/tree/MethodInsnNode;", "getOwnerClassName", "(Lorg/objectweb/asm/tree/MethodInsnNode;)Ljava/lang/String;", "dex", "", "Ljava/io/File;", "output", "api", "dokitTransform", "", "transformer", "Lkotlin/Function1;", "", "Ljava/util/zip/ZipFile;", "entryFactory", "Ljava/util/zip/ZipEntry;", "Lorg/apache/commons/compress/archivers/zip/ZipArchiveEntry;", "Ljava/io/OutputStream;", "getMethodExitInsnNodes", "Lkotlin/sequences/Sequence;", "Lorg/objectweb/asm/tree/InsnNode;", "Lorg/objectweb/asm/tree/InsnList;", "isEmptyMethod", "", "Lorg/objectweb/asm/tree/MethodNode;", "isGetSetMethod", "isMainMethod", "className", "isRelease", "Lcom/android/build/gradle/api/BaseVariant;", "Lcom/didiglobal/booster/transform/TransformContext;", "isSingleMethod", "lastPath", "println", "buildSrc"})
public final class DoKitExtKt {
    
    /**
     * ================================================
     * 作    者：jint（金台）
     * 版    本：1.0
     * 创建日期：2020/5/19-18:00
     * 描    述：dokit 对象扩展
     * 修订历史：
     * ================================================
     */
    public static final boolean isGetSetMethod(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.MethodNode $this$isGetSetMethod) {
        return false;
    }
    
    public static final boolean isSingleMethod(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.MethodNode $this$isSingleMethod) {
        return false;
    }
    
    public static final boolean isEmptyMethod(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.MethodNode $this$isEmptyMethod) {
        return false;
    }
    
    public static final boolean isMainMethod(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.MethodNode $this$isMainMethod, @org.jetbrains.annotations.NotNull()
    java.lang.String className) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final kotlin.sequences.Sequence<org.objectweb.asm.tree.InsnNode> getMethodExitInsnNodes(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.InsnList $this$getMethodExitInsnNodes) {
        return null;
    }
    
    public static final boolean isRelease(@org.jetbrains.annotations.NotNull()
    com.android.build.gradle.api.BaseVariant $this$isRelease) {
        return false;
    }
    
    public static final boolean isRelease(@org.jetbrains.annotations.NotNull()
    com.didiglobal.booster.transform.TransformContext $this$isRelease) {
        return false;
    }
    
    public static final void println(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$println) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String lastPath(@org.jetbrains.annotations.NotNull()
    java.io.File $this$lastPath) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getOwnerClassName(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.MethodInsnNode $this$ownerClassName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getFormatSuperName(@org.jetbrains.annotations.NotNull()
    org.objectweb.asm.tree.ClassNode $this$formatSuperName) {
        return null;
    }
    
    public static final int dex(@org.jetbrains.annotations.NotNull()
    java.io.File $this$dex, @org.jetbrains.annotations.NotNull()
    java.io.File output, int api) {
        return 0;
    }
    
    /**
     * Transform this file or directory to the output by the specified transformer
     *
     * @param output The output location
     * @param transformer The byte data transformer
     */
    public static final void dokitTransform(@org.jetbrains.annotations.NotNull()
    java.io.File $this$dokitTransform, @org.jetbrains.annotations.NotNull()
    java.io.File output, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], byte[]> transformer) {
    }
    
    public static final void dokitTransform(@org.jetbrains.annotations.NotNull()
    java.util.zip.ZipFile $this$dokitTransform, @org.jetbrains.annotations.NotNull()
    java.io.File output, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.zip.ZipEntry, ? extends org.apache.commons.compress.archivers.zip.ZipArchiveEntry> entryFactory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], byte[]> transformer) {
    }
    
    public static final void dokitTransform(@org.jetbrains.annotations.NotNull()
    java.util.zip.ZipFile $this$dokitTransform, @org.jetbrains.annotations.NotNull()
    java.io.OutputStream output, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.zip.ZipEntry, ? extends org.apache.commons.compress.archivers.zip.ZipArchiveEntry> entryFactory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], byte[]> transformer) {
    }
}