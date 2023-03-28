package com.setjy.automationbusinesstask.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.setjy.automationbusinesstask.ui.base.ui.ProductItem
import com.setjy.automationbusinesstask.ui.model.ProductUI

@Composable
fun GoodsScreen() {
    val list = listOf(
        ProductUI(
            itemName = "СОРОЧКА МУЖ. MAJESTIC LEGATE SH22065-R",
            itemLink = "",
            itemPrice = 23142,
            itemImage = "",
        ),
        ProductUI(
            itemName = "СОРОЧКА МУЖ. MAJESTIC LEGATE SH22065-R",
            itemLink = "",
            itemPrice = 231,
            itemImage = "",
        ),
    )
    LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
        items(items = list) {
            ProductItem(cardItem = it)
        }
    }
}