package com.example.randomfood.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.entities.FoodInfoEntity

class SharedViewModel : ViewModel() {
    var foodInfoEntity by mutableStateOf<FoodInfoEntity?>(null)
        private set

    fun setFoodInfo(entity: FoodInfoEntity) {
        foodInfoEntity = entity
    }
}