package com.example.randomfood.ui.food_list_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.core.base.BaseViewState
import com.example.core.ui.EmptyView
import com.example.core.ui.ErrorView
import com.example.core.ui.LoadingView
import com.example.core.utils.cast
import com.example.domain.entities.FoodInfoEntity
import com.example.randomfood.ui.food_list_screen.models.FoodListUiState
import com.example.randomfood.ui.food_list_screen.views.FoodListContent


@Composable
fun FoodListScreen(
    viewState: BaseViewState<*>,
    initUi: () -> Unit,
    pressOnReload: () -> Unit,
    foodItemClick: (FoodInfoEntity) -> Unit
) {
    val dataState by lazy { viewState.cast<BaseViewState.Data<FoodListUiState>>().value }
    val throwable by lazy { viewState.cast<BaseViewState.Error>().throwable }

    when (viewState) {
        is BaseViewState.Data -> {
            FoodListContent(
                state = dataState,
                pressOnReload = { pressOnReload.invoke() },
                foodItemClick = { foodItemClick.invoke(it) },
            )
        }

        is BaseViewState.Empty -> EmptyView()
        is BaseViewState.Error -> ErrorView(
            e = throwable,
            action = { initUi.invoke() }
        )

        is BaseViewState.Loading -> LoadingView()
    }

    LaunchedEffect(key1 = true) {
        initUi.invoke()
    }
}