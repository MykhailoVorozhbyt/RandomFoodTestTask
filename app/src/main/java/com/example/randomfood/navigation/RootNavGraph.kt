package com.example.randomfood.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.navigation.Graph
import com.example.core.navigation.Screen
import com.example.randomfood.ui.food_information.FoodInformationScreen
import com.example.randomfood.ui.food_information.FoodInformationViewModel
import com.example.randomfood.ui.food_information.model.FoodInformationUiEvent
import com.example.randomfood.ui.food_list_screen.FoodListScreen
import com.example.randomfood.ui.food_list_screen.FoodListViewModel
import com.example.randomfood.ui.food_list_screen.models.FoodListUiEvent
import com.example.randomfood.utils.SharedViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootNavGraph(navController: NavHostController) {
    val sharedViewModel: SharedViewModel = viewModel()
    NavHost(
        navController,
        route = Graph.Root.route,
        startDestination = Screen.FoodList.route
    ) {
        composable(
            route = Screen.FoodList.route
        ) { backStackEntry ->
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
                    sharedViewModel.setFoodInfo(it)
                    navController.navigate(Screen.FoodInformation.route)
                }
            )
        }

        composable(
            route = Screen.FoodInformation.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(1000)
                )
            }
        ) { backStackEntry ->
            val viewModel = koinViewModel<FoodInformationViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            FoodInformationScreen(
                viewState = uiState,
                initUi = {
                    viewModel.onTriggerEvent(
                        FoodInformationUiEvent.InitUiScreen(
                            sharedViewModel.foodInfoEntity
                        )
                    )
                },
                popBackClick = {
                    navController.popBackStack()
                },
            )
        }
    }

}