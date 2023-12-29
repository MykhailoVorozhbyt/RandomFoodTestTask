package com.example.randomfood.ui.food_information.model

import com.example.domain.entities.FoodInfoEntity

sealed class FoodInformationUiEvent {
    data class InitUiScreen(val model: FoodInfoEntity?) : FoodInformationUiEvent()
}