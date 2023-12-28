package com.example.core.navigation

import com.example.core.base.BaseRoute


sealed class Screen(route: String) : BaseRoute(route) {
    data object FoodList : BaseRoute(FOOD_LIST_ROUTE)
    data object FoodInformation : BaseRoute(FOOD_INFORMATION_ROUTE) {
        fun setId(id: String) = "$FOOD_INFORMATION_ROUTE/$id"
    }

    companion object {
        const val FOOD_LIST_ROUTE = "FoodListRoute"
        const val FOOD_INFORMATION_ROUTE = "FoodInformationRoute"
    }
}


