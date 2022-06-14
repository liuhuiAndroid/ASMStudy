package com.study.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestKit : Plugin<Project> {
    override fun apply(project: Project) {
        val pluginSwitch = project.getProperty("DOKIT_PLUGIN_SWITCH", 0)
        "===DOKIT_PLUGIN_SWITCH.$pluginSwitch===".println()

        project.plugins.forEach {

        }
    }
}

fun <T> Project.getProperty(name: String, defaultValue: T): T {
    val value = findProperty(name) ?: return defaultValue
    return when (defaultValue) {
        is Boolean -> if (value is Boolean) value as T else value.toString().toBoolean() as T
        is Byte -> if (value is Byte) value as T else value.toString().toByte() as T
        is Short -> if (value is Short) value as T else value.toString().toShort() as T
        is Int -> if (value is Int) value as T else value.toString().toInt() as T
        is Float -> if (value is Float) value as T else value.toString().toFloat() as T
        is Long -> if (value is Long) value as T else value.toString().toLong() as T
        is Double -> if (value is Double) value as T else value.toString().toDouble() as T
        is String -> if (value is String) value as T else value.toString() as T
        else -> value as T
    }
}

fun String.println() {
    println("[dokit plugin]===>$this")
}