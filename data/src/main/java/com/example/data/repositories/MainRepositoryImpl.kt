package com.example.data.repositories

import com.example.data.remote_api.RemoteApi
import com.example.domain.responses.FoodInformationResponse
import com.example.domain.responses.RandomResponse

class MainRepositoryImpl(
    private val api: RemoteApi
) : MainRepository {
    override suspend fun getRandomFoodList(): RandomResponse =
        api.getRandomFoodList()

    override suspend fun getFoodById(itemId: String): FoodInformationResponse =
        api.getFoodById(itemId)
}