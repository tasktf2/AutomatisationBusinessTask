package com.setjy.automationbusinesstask.ui.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StoreItem(storeName: String, storeAddress: String, onStoreClicked: () -> Unit) {
    Card(elevation = 4.dp, onClick = onStoreClicked) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = storeName, style = MaterialTheme.typography.body1)
            Text(text = storeAddress, style = MaterialTheme.typography.caption)
        }
    }
}