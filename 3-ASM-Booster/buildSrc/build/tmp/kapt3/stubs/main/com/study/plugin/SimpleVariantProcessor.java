package com.study.plugin;

import java.lang.System;

@com.google.auto.service.AutoService(value = {com.didiglobal.booster.task.spi.VariantProcessor.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/study/plugin/SimpleVariantProcessor;", "Lcom/didiglobal/booster/task/spi/VariantProcessor;", "project", "Lorg/gradle/api/Project;", "(Lorg/gradle/api/Project;)V", "process", "", "variant", "Lcom/android/build/gradle/api/BaseVariant;", "buildSrc"})
public final class SimpleVariantProcessor implements com.didiglobal.booster.task.spi.VariantProcessor {
    
    @java.lang.Override()
    public void process(@org.jetbrains.annotations.NotNull()
    com.android.build.gradle.api.BaseVariant variant) {
    }
    
    public SimpleVariantProcessor(@org.jetbrains.annotations.NotNull()
    org.gradle.api.Project project) {
        super();
    }
}