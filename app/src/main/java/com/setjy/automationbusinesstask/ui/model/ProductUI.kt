package com.setjy.automationbusinesstask.ui.model

import android.graphics.Bitmap
import com.setjy.automationbusinesstask.domain.model.Product
import com.setjy.automationbusinesstask.ui.base.Item

data class ProductUI(
    val itemName: String,
    val itemLink: String,
    val itemPrice: Int,
    val itemImage: Bitmap?
) : Item

fun Product.toUi() = ProductUI(
    itemName = productName,
    itemLink = productLink,
    itemPrice = productPrice,
    itemImage = productImage
)