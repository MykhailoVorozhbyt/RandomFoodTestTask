package com.example.randomfood.di

import com.example.randomfood.ui.food_list_screen.FoodListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::FoodListViewModel)
}