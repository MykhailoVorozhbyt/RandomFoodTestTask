package com.example.randomfood.ui.food_list_screen.models

import com.example.core.base.BaseLoaderState
import com.example.domain.responses.FoodItemsResponse

data class FoodListUiState(
    override val isLoaderVisible: Boolean = false,
    val title: String = "",
    val food: List<FoodItemsResponse> = listOf()
) : BaseLoaderState()
