package com.setjy.automationbusinesstask.ui.model

import com.setjy.automationbusinesstask.ui.base.Item

data class StoreUI(
    val storeName: String,
    val storeAddress: String,
    val longitude: Double,
    val latitude: Double
) : Item