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

sealed class StoreState {

    data class Success(val storeList: List<StoreUI>) : StoreState()
    object Loading : StoreState()
    object Error : StoreState()
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
}