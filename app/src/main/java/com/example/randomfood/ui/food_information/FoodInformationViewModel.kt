package com.example.randomfood.ui.food_information

import com.example.core.base.BaseViewState
import com.example.core.base.vm.MviViewModel
import com.example.core.utils.AppDispatchers
import com.example.data.repositories.MainRepository
import com.example.domain.constants.Constants
import com.example.domain.models.FoodInformationModel
import com.example.randomfood.ui.food_information.model.FoodInformationUiEvent
import com.example.randomfood.ui.food_information.model.FoodInformationUiState
import kotlinx.coroutines.delay

class FoodInformationViewModel(
    private val mainRepository: MainRepository,
    private val dispatchers: AppDispatchers,
) :
    MviViewModel<BaseViewState<FoodInformationUiState>, FoodInformationUiEvent>() {
    override fun onTriggerEvent(eventType: FoodInformationUiEvent) {
        when (eventType) {
            is FoodInformationUiEvent.InitUiScreen -> {
                startLoading()
                triggerEvent(eventType)
            }
        }
    }

    private fun setDataState(state: FoodInformationUiState) {
        setState(BaseViewState.Data(state))
    }

    private fun triggerEvent(event: FoodInformationUiEvent.InitUiScreen) {
        if (event.model == null) {
            handleError(Throwable(Constants.UNKNOWN_ERROR))
            return
        }
        setDataState(
            FoodInformationUiState(
                isLoaderVisible = true
            )
        )
        safeLaunch(dispatchers.io) {
            try {
                val result = mainRepository.getFoodById(event.model.id)
                delay(1000L)
                setDataState(
                    FoodInformationUiState(
                        isLoaderVisible = false,
                        foodInformation = FoodInformationModel(
                            id = result.id,
                            text = result.text,
                            photoUrl = event.model.photoName,
                            color = event.model.color,
                        )
                    )
                )
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }


}