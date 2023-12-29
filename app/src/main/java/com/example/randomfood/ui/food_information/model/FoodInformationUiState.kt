package com.example.randomfood.ui.food_information.model

import com.example.core.base.BaseLoaderState
import com.example.domain.models.FoodInformationModel

data class FoodInformationUiState(
    override val isLoaderVisible: Boolean = false,
    val foodInformation: FoodInformationModel = FoodInformationModel()
) : BaseLoaderState()