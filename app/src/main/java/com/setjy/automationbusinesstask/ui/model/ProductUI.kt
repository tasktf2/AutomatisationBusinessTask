package com.setjy.automationbusinesstask.ui.model

import com.setjy.automationbusinesstask.ui.base.Item

data class ProductUI(
    val itemName: String,
    val itemLink: String,
    val itemPrice: Int,
    val itemImage: String
) : Item