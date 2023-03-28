package com.setjy.automationbusinesstask.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.setjy.automationbusinesstask.ui.base.ui.StoreItem
import com.setjy.automationbusinesstask.ui.model.StoreUI

@Composable
fun StoresScreen() {
    val list = listOf(
        StoreUI(
            storeName = "Н. Тагил-1 ИП Васев авт",
            storeAddress = "ТЦ «Александровский пассаж», 4 эт., пр. Ленина, 22",
            longitude = 59.95944,
            latitude = 57.90826
        ),

        StoreUI(
            storeName = "Н. Тагил-2 ИП Васев авт",
            storeAddress = "ТЦ «Колизей» , 1 эт., пр. Мира, 21",
            longitude = 59.98021,
            latitude = 57.91099
        ),

        StoreUI(
            storeName = "Н. Тагил-1 ИП Васев авт",
            storeAddress = "ТЦ «Александровский пассаж», 4 эт., пр. Ленина, 22",
            longitude = 59.95944,
            latitude = 57.90826
        ),

        StoreUI(
            storeName = "_Снежинск ИП Довгун авт",
            storeAddress = "ТК «Меркурий», 2 эт., ул. Забабахина, 19",
            longitude = 60.75738,
            latitude = 56.07832
        ),
    )
    LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = list) { store ->
            StoreItem(storeName = store.storeName, storeAddress = store.storeAddress)
        }
    }
}