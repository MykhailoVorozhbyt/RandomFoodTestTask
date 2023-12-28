package com.example.data.remote_api

import com.example.domain.responses.FoodInformationResponse
import com.example.domain.responses.RandomResponse
import retrofit2.Retrofit

class RemoteApiImpl(
    retrofit: Retrofit
) : RemoteApi {
    private val api = retrofit.create(RemoteApi::class.java)

    override suspend fun getRandomFoodList(): RandomResponse =
        api.getRandomFoodList()

    override suspend fun getFoodById(itemId: String): FoodInformationResponse =
        api.getFoodById(itemId)
}