package com.example.randomfood.ui.food_list_screen

import com.example.core.base.BaseViewState
import com.example.core.base.vm.MviViewModel
import com.example.core.utils.AppDispatchers
import com.example.data.repositories.MainRepository
import com.example.randomfood.ui.food_list_screen.models.FoodListUiEvent
import com.example.randomfood.ui.food_list_screen.models.FoodListUiState
import kotlinx.coroutines.delay

class FoodListViewModel(
    private val mainRepository: MainRepository,
    private val dispatchers: AppDispatchers,
) :
    MviViewModel<BaseViewState<FoodListUiState>, FoodListUiEvent>() {
    override fun onTriggerEvent(eventType: FoodListUiEvent) {
        when (eventType) {
            is FoodListUiEvent.ReloadClick, FoodListUiEvent.InitUiScreen -> {
                startLoading()
                triggerEvent()
            }
        }
    }

    private fun setDataState(state: FoodListUiState) {
        setState(BaseViewState.Data(state))
    }

    private fun triggerEvent() {
        setDataState(
            FoodListUiState(
                isLoaderVisible = true
            )
        )
        safeLaunch(dispatchers.io) {
            try {
                val result = mainRepository.getRandomFoodList()
                delay(1000L)
                setDataState(
                    FoodListUiState(
                        isLoaderVisible = false,
                        title = result.title,
                        food = result.food,
                    )
                )
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }


}