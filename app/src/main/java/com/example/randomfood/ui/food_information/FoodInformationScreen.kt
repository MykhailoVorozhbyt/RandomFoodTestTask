package com.example.randomfood.ui.food_information

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.core.base.BaseViewState
import com.example.core.ui.EmptyView
import com.example.core.ui.ErrorView
import com.example.core.ui.LoadingView
import com.example.core.utils.cast
import com.example.randomfood.ui.food_information.model.FoodInformationUiState
import com.example.randomfood.ui.food_information.views.FoodInformationContent


@Composable
fun FoodInformationScreen(
    viewState: BaseViewState<*>,
    initUi: () -> Unit,
    popBackClick: () -> Unit
) {

    val dataState by lazy { viewState.cast<BaseViewState.Data<FoodInformationUiState>>().value }
    val throwable by lazy { viewState.cast<BaseViewState.Error>().throwable }

    when (viewState) {
        is BaseViewState.Data -> {
            FoodInformationContent(dataState) {
                popBackClick.invoke()
            }
        }

        is BaseViewState.Empty -> EmptyView()
        is BaseViewState.Error -> ErrorView(
            e = throwable,
            action = { popBackClick.invoke() }
        )

        is BaseViewState.Loading -> LoadingView()
    }

    LaunchedEffect(key1 = true) {
        initUi.invoke()
    }
}