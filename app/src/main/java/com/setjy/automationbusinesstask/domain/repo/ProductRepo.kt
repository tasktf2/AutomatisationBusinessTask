package com.setjy.automationbusinesstask.domain.repo

import com.setjy.automationbusinesstask.domain.model.Product

interface ProductRepo {

    suspend fun getProducts(): List<Product>
}