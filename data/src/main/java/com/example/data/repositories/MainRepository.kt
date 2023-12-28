package com.example.data.repositories

import com.example.domain.responses.FoodInformationResponse
import com.example.domain.responses.RandomResponse


interface MainRepository {
    suspend fun getRandomFoodList(): RandomResponse
    suspend fun getFoodById(itemId: String): FoodInformationResponse
}