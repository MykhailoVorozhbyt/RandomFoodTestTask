package com.example.randomfood.ui.food_list_screen.models

import com.example.domain.responses.FoodItemsResponse

data class FoodListUiState(
    val isLoaderVisible: Boolean = false,
    val title: String = "",
    val food: List<FoodItemsResponse> = listOf()
)