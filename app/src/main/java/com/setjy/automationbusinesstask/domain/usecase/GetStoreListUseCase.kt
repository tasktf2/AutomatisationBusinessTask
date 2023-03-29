package com.setjy.automationbusinesstask.domain.usecase

import com.setjy.automationbusinesstask.domain.base.UseCase
import com.setjy.automationbusinesstask.domain.model.Store
import com.setjy.automationbusinesstask.domain.repo.StoreRepo

class GetStoreListUseCase(private val repo: StoreRepo) : UseCase<Unit, List<Store>> {

    override suspend fun execute(params: Unit): List<Store> = repo.getStoreList()
}