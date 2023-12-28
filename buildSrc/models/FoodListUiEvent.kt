package com.example.randomfood.ui.food_list_screen.models

sealed class FoodListUiEvent {
    data object InitUiScreen : FoodListUiEvent()
    data class FoodItemClick(val id: String) : FoodListUiEvent()
}
