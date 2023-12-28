package com.example.data.remote_api

import com.example.domain.responses.FoodInformationResponse
import com.example.domain.responses.RandomResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApi {

    @GET("/items/random")
    suspend fun getRandomFoodList(): RandomResponse

    @GET("/texts/{itemId}")
    suspend fun getFoodById(
        @Query("itemId") itemId: String
    ): FoodInformationResponse
}
