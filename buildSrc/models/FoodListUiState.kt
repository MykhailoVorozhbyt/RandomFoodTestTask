package com.example.randomfood.ui.food_list_screen.models

import com.example.domain.responses.FoodItemsResponse

data class FoodListUiState(
    val toolBarName: String = "",
    val foodList: List<FoodItemsResponse> = listOf()
)
