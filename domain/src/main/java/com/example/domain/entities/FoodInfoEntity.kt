package com.example.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodInfoEntity(
    val id: String = "",
    val photoName: String? = null,
    val color: String = ""
) : Parcelable