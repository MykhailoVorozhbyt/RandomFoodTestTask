package com.example.domain.responses

import com.google.gson.annotations.SerializedName

data class FoodItemsResponse(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("image")
    var image: String?,
    @SerializedName("color")
    var color: String
)