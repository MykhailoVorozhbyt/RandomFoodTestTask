package com.example.domain.responses

import com.google.gson.annotations.SerializedName

data class FoodInformationResponse(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("text")
    val text: String = ""
)