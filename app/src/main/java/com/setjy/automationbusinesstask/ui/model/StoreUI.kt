package com.setjy.automationbusinesstask.ui.model

import com.setjy.automationbusinesstask.domain.model.Store
import com.setjy.automationbusinesstask.ui.base.Item

data class StoreUI(
    val storeName: String,
    val storeAddress: String,
    val longitude: Double,
    val latitude: Double
) : Item

fun Store.toUi() = StoreUI(
    storeName = storeName,
    storeAddress = storeAddress,
    longitude = storeLongitude,
    latitude = storeLatitude
)