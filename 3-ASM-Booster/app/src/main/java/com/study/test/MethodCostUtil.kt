package com.study.test

import android.util.Log

/**
 * ================================================
 * 作    者：jint（金台）
 * 版    本：1.0
 * 创建日期：2020/2/29-15:31
 * 描    述：全局的函数耗时工具类
 * 修订历史：
 * ================================================
 */
public object MethodCostUtil {
    private const val TAG = "DOKIT_SLOW_METHOD"

    private var startTime = 0L

    @Synchronized
    fun recodeObjectMethodCostStart(thresholdTime: Int, methodName: String, classObj: Any?) {
        val startT = System.currentTimeMillis()
        startTime = startT
    }

    fun recodeObjectMethodCostEnd(thresholdTime: Int, methodName: String, classObj: Any?) {
        val endT = System.currentTimeMillis()
        Log.i(TAG, "====Dokit:cost:${endT - startTime}ms.")
    }


    fun recodeStaticMethodCostStart(thresholdTime: Int, methodName: String) {
        Log.i(TAG, "====Dokit:recodeStaticMethodCostStart" + System.currentTimeMillis())
    }

    private fun printApplicationStartTime(methodName: String) {
        Log.i(TAG, "====Dokit:printApplicationStartTime" + System.currentTimeMillis())
    }

    private fun printActivityStartTime(methodName: String) {
        Log.i(TAG, "====Dokit:printActivityStartTime" + System.currentTimeMillis())
    }

    fun recodeStaticMethodCostEnd(thresholdTime: Int, methodName: String) {
        Log.i(TAG, "====Dokit:recodeStaticMethodCostEnd" + System.currentTimeMillis())
    }


}