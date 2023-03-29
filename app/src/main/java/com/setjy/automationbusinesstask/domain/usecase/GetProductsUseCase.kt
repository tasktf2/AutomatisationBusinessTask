package com.setjy.automationbusinesstask.domain.usecase

import com.setjy.automationbusinesstask.domain.base.UseCase
import com.setjy.automationbusinesstask.domain.model.Product
import com.setjy.automationbusinesstask.domain.repo.ProductRepo
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repo: ProductRepo) :
    UseCase<Unit, List<Product>> {

    override suspend fun execute(params: Unit): List<Product> = repo.getProducts()
}