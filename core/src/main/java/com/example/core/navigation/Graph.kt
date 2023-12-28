package com.example.core.navigation

import com.example.core.base.BaseRoute

sealed class Graph(graphRoute: String) : BaseRoute(graphRoute) {
    object Root : BaseRoute("RootGraph")
}
