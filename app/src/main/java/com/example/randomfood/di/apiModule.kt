package com.example.randomfood.di

import com.example.data.remote_api.RemoteApi
import com.example.data.remote_api.RemoteApiImpl
import com.example.randomfood.BuildConfig
import com.example.core.utils.IgnoreExclusionStrategy
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {

    val provideGson: Gson by lazy {
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .addSerializationExclusionStrategy(com.example.core.utils.IgnoreExclusionStrategy()).create()
    }

    val provideConverterFactory: Converter.Factory by lazy { GsonConverterFactory.create(provideGson) }

    val okHttpClient: OkHttpClient by lazy {
        val interceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY else
                HttpLoggingInterceptor.Level.NONE
        }
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .build()
    }

    val baseUrl: String by lazy {
        BuildConfig.API_BASE_URL
    }

    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(provideConverterFactory)
            .build()
    }

    fun provideRemoteApi(retrofit: Retrofit): RemoteApi =
        RemoteApiImpl(retrofit)

    single { provideRetrofit() }
    single { provideRemoteApi(get()) }

}