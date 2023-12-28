package com.example.randomfood.app

import android.app.Application
import com.example.randomfood.di.apiModule
import com.example.randomfood.di.helperModule
import com.example.randomfood.di.repositoryModule
import com.example.randomfood.di.viewModelModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class RandomFoodApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            loadKoinModules(
                listOf(
                    apiModule,
                    repositoryModule,
                    viewModelModule,
                    helperModule
                )
            )
        }
    }
}