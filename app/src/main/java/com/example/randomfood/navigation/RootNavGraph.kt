package com.example.randomfood.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.navigation.Graph
import com.example.core.navigation.Screen
import com.example.randomfood.ui.food_list_screen.FoodListScreen
import com.example.randomfood.ui.food_list_screen.FoodListViewModel
import com.example.randomfood.ui.food_list_screen.models.FoodListUiEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController,
        route = Graph.Root.route,
        startDestination = Screen.FoodList.route
    ) {
        composable(route = Screen.FoodList.route) {
            val viewModel = koinViewModel<FoodListViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            FoodListScreen(
                viewState = uiState,
                initUi = {
                    viewModel.onTriggerEvent(FoodListUiEvent.InitUiScreen)
                },
                pressOnReload = {
                    viewModel.onTriggerEvent(FoodListUiEvent.ReloadClick)
                },
                foodItemClick = {
                    navController.navigate(Screen.FoodInformation.setId(it))
                }
            )
        }

        composable(route = Screen.FoodInformation.route) {

        }
    }

}