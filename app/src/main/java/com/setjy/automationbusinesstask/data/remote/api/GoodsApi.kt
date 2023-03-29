package com.setjy.automationbusinesstask.data.remote.api

import com.setjy.automationbusinesstask.data.remote.response.GoodsRemote
import retrofit2.http.GET

interface GoodsApi {

    @GET("goods")
    suspend fun getGoodsList(): List<GoodsRemote>
}