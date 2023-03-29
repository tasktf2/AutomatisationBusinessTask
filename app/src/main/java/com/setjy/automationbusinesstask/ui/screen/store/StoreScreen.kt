package com.setjy.automationbusinesstask.ui.screen.store

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.setjy.automationbusinesstask.ui.base.ui.StoreItem
import com.setjy.automationbusinesstask.ui.model.StoreUI
import com.setjy.automationbusinesstask.ui.screen.base.ErrorScreen
import com.setjy.automationbusinesstask.ui.screen.base.LoadingScreen


@Composable
fun StoreScreen(uiState: StoreState, onTryAgainClicked:()->Unit) {
    when (uiState) {
        StoreState.Error -> ErrorScreen(onTryAgainClicked = onTryAgainClicked)
        StoreState.Loading -> LoadingScreen()
        is StoreState.Success -> StoreSuccessScreen(storeList = uiState.storeList)
    }
}
@Composable
fun StoreSuccessScreen(storeList: List<StoreUI>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = storeList) { store ->
            StoreItem(storeName = store.storeName, storeAddress = store.storeAddress)
        }
    }
}