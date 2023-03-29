package com.setjy.automationbusinesstask.di

import com.setjy.automationbusinesstask.domain.base.UseCase
import com.setjy.automationbusinesstask.domain.model.Product
import com.setjy.automationbusinesstask.domain.model.Store
import com.setjy.automationbusinesstask.domain.repo.ProductRepo
import com.setjy.automationbusinesstask.domain.repo.StoreRepo
import com.setjy.automationbusinesstask.domain.usecase.GetProductsUseCase
import com.setjy.automationbusinesstask.domain.usecase.GetStoreListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetProductsUseCase(productRepo: ProductRepo): UseCase<Unit, List<Product>> =
        GetProductsUseCase(productRepo)

    @Provides
    fun provideGetStoreListUseCase(storeRepo: StoreRepo): UseCase<Unit, List<Store>> =
        GetStoreListUseCase(storeRepo)
}