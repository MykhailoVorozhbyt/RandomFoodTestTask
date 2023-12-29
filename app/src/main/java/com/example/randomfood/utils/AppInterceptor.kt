package com.example.randomfood.utils

import com.example.domain.constants.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AppInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .url(originalRequest.url)
        val response = chain.proceed(newRequest.build())
        if (response.isSuccessful.not()) {
            throw IOException(Constants.UNKNOWN_API_ERROR)
        }
        return response
    }
}