package com.setjy.automationbusinesstask.ui.screen.goods

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.setjy.automationbusinesstask.domain.base.UseCase
import com.setjy.automationbusinesstask.domain.model.Product
import com.setjy.automationbusinesstask.ui.model.ProductUI
import com.setjy.automationbusinesstask.ui.model.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class GoodsState {

    data class Success(val products: List<ProductUI>) : GoodsState()
    object Loading : GoodsState()
    object Error : GoodsState()
}

@HiltViewModel
class GoodsViewModel @Inject constructor(
    private val getProductsUseCase: @JvmSuppressWildcards UseCase<Unit, List<Product>>
) :
    ViewModel() {

    var uiState: GoodsState by mutableStateOf(GoodsState.Loading)
        private set

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            uiState = GoodsState.Loading
            uiState = try {
                GoodsState.Success(getProductsUseCase.execute(Unit).map(Product::toUi))
            } catch (e: Exception) {
                Log.d("GoodsViewModel", e.stackTraceToString())
                GoodsState.Error
            }
        }
    }
}