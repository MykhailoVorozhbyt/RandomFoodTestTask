package com.example.core.utils

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes

class IgnoreExclusionStrategy : ExclusionStrategy {

    override fun shouldSkipClass(clazz: Class<*>?): Boolean = false

    override fun shouldSkipField(f: FieldAttributes?): Boolean {
        return f?.getAnnotation(Ignore::class.java) != null
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Ignore
