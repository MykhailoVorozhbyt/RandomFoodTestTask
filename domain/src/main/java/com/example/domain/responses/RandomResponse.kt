package com.example.domain.responses

import com.google.gson.annotations.SerializedName

data class RandomResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("items")
    val food: List<FoodItemsResponse>
)
