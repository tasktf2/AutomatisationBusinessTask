package com.setjy.automationbusinesstask.domain.model

import com.setjy.automationbusinesstask.domain.base.Model

data class Store(
    val storeName: String,
    val storeAddress: String,
    val storeLongitude: Double,
    val storeLatitude: Double
) : Model
