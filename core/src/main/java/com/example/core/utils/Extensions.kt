package com.example.core.utils

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.ui.graphics.Color

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}

fun String.toColor(): Color {
    val cleanHex = if (startsWith("#")) substring(1) else this
    return Color(android.graphics.Color.parseColor("#$cleanHex"))
}

inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}