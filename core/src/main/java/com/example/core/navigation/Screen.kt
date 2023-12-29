package com.example.core.navigation

import com.example.core.base.BaseRoute
import com.example.domain.constants.Constants
import com.example.domain.entities.FoodInfoEntity


sealed class Screen(route: String) : BaseRoute(route) {
    data object FoodList : BaseRoute(FOOD_LIST_ROUTE)
    data object FoodInformation : BaseRoute(FOOD_INFORMATION_ROUTE)
    companion object {
        const val FOOD_LIST_ROUTE = "FoodListRoute"
        const val FOOD_INFORMATION_ROUTE = "FoodInformationRoute"
    }
}


