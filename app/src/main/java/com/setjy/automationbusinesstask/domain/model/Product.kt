package com.setjy.automationbusinesstask.domain.model

import android.graphics.Bitmap
import com.setjy.automationbusinesstask.domain.base.Model

data class Product(
    val productName: String,
    val productLink: String,
    val productPrice: Int,
    val productImage: Bitmap?
) : Model

