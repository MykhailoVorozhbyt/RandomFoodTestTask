package com.example.randomfood.di

import com.example.data.repositories.MainRepository
import com.example.data.repositories.MainRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}
