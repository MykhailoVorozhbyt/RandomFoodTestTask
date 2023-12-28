package com.example.core.utils

import androidx.compose.ui.graphics.Color

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}

fun String.toColor(): Color {
    val cleanHex = if (startsWith("#")) substring(1) else this
    return Color(android.graphics.Color.parseColor("#$cleanHex"))
}