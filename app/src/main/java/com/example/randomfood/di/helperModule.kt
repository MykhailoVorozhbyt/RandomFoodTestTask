package com.example.randomfood.di

import com.example.core.utils.AppDispatchers
import org.koin.dsl.module

val helperModule = module {
    single { AppDispatchers() }
}