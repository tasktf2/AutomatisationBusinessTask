package com.setjy.automationbusinesstask.data.repo

import com.setjy.automationbusinesstask.data.remote.api.GoodsApi
import com.setjy.automationbusinesstask.data.remote.response.GoodsRemote
import com.setjy.automationbusinesstask.data.remote.response.toDomain
import com.setjy.automationbusinesstask.domain.model.Product
import com.setjy.automationbusinesstask.domain.repo.ProductRepo
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(private val api: GoodsApi) : ProductRepo {

    override suspend fun getProducts(): List<Product> =
        api.getGoodsList().map(GoodsRemote::toDomain)
}