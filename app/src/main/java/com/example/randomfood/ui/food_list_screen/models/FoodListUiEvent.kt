package com.example.randomfood.ui.food_list_screen.models

sealed class FoodListUiEvent {
    data object ReloadClick : FoodListUiEvent()
    data object InitUiScreen : FoodListUiEvent()
}