package com.setjy.automationbusinesstask.di

import com.setjy.automationbusinesstask.data.repo.ProductRepoImpl
import com.setjy.automationbusinesstask.data.repo.StoreRepoImpl
import com.setjy.automationbusinesstask.domain.repo.ProductRepo
import com.setjy.automationbusinesstask.domain.repo.StoreRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun bindProductRepo(productRepoImpl: ProductRepoImpl): ProductRepo

    @Binds
    fun bindStoreRepo(storeRepoImpl: StoreRepoImpl): StoreRepo
}