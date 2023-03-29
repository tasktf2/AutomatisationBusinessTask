package com.setjy.automationbusinesstask.data.remote.api

import com.setjy.automationbusinesstask.data.remote.response.StoreRemote
import retrofit2.http.GET

interface StoreApi {

    @GET("stores")
    suspend fun getStoreList(): List<StoreRemote>
}