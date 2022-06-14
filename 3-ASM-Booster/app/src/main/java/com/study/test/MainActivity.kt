package com.study.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "DOKIT_SLOW_METHOD"

    override fun onCreate(savedInstanceState: Bundle?) {
        val startT = System.currentTimeMillis()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread.sleep(100)
        val endT = System.currentTimeMillis()
        Log.i(TAG, "====Dokit:cost:${endT - startT}ms. in Activity")
    }
}