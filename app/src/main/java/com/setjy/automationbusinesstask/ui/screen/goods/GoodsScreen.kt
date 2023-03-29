package com.setjy.automationbusinesstask.ui.screen.goods

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.setjy.automationbusinesstask.ui.base.ui.ProductItem
import com.setjy.automationbusinesstask.ui.model.ProductUI
import com.setjy.automationbusinesstask.ui.screen.base.ErrorScreen
import com.setjy.automationbusinesstask.ui.screen.base.LoadingScreen


@Composable
fun GoodsScreen(uiState: GoodsState, onTryAgainClicked: () -> Unit) {
    when (uiState) {
        GoodsState.Error -> ErrorScreen(onTryAgainClicked = onTryAgainClicked)
        GoodsState.Loading -> LoadingScreen()
        is GoodsState.Success -> GoodsSuccessScreen(uiState.products)
    }
}

@Composable
fun GoodsSuccessScreen(products: List<ProductUI>) {
    LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
        items(items = products) {
            ProductItem(cardItem = it)
        }
    }
}