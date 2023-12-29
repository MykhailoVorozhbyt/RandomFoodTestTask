package com.example.data.remote_api

import com.example.domain.responses.FoodInformationResponse
import com.example.domain.responses.RandomResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/items/random")
    suspend fun getRandomFoodList(): RandomResponse

    @GET("/texts/{itemId}")
    suspend fun getFoodById(
        @Path("itemId") itemId: String
    ): FoodInformationResponse
}
