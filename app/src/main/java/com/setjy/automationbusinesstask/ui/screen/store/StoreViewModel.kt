package com.setjy.automationbusinesstask.ui.screen.store

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.setjy.automationbusinesstask.domain.base.UseCase
import com.setjy.automationbusinesstask.domain.model.Store
import com.setjy.automationbusinesstask.ui.model.StoreUI
import com.setjy.automationbusinesstask.ui.model.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class StoreState(open val storeList: List<StoreUI>) {

    data class Success(override val storeList: List<StoreUI>) : StoreState(storeList)
    object Loading : StoreState(emptyList())
    object Error : StoreState(emptyList())
    data class ShowMap(override val storeList: List<StoreUI>, val storeInfo: StoreUI) :
        StoreState(storeList)
}

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getStoreListUseCase: @JvmSuppressWildcards UseCase<Unit, List<Store>>
) :
    ViewModel() {

    var uiState: StoreState by mutableStateOf(StoreState.Loading)
        private set

    init {
        getStoreList()
    }

    fun getStoreList() {
        viewModelScope.launch {
            uiState = StoreState.Loading
            uiState = try {
                StoreState.Success(getStoreListUseCase.execute(Unit).map(Store::toUi))
            } catch (e: Exception) {
                Log.d("StoreViewModel", e.stackTraceToString())
                StoreState.Error
            }
        }
    }

    fun showMap(storeInfo: StoreUI) {
        uiState = StoreState.ShowMap(uiState.storeList, storeInfo)
    }

    fun backToStoreList() {
        uiState = StoreState.Success(uiState.storeList)
    }
}