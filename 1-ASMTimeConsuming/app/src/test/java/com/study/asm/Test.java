package com.study.asm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test {

    @ASMTest
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(1_000);
        long s = System.currentTimeMillis();
        System.out.println("execute:" + (s - l) + "ms.");
    }

    public static void main2(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(1_000);
        long s = System.currentTimeMillis();
        System.out.println("execute:" + (s - l) + "ms.");
    }

    @ASMTest
    public static void main3(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(1_000);
        long s = System.currentTimeMillis();
        System.out.println("execute:" + (s - l) + "ms.");
    }

    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.METHOD)
    public @interface ASMTest {
    }

}