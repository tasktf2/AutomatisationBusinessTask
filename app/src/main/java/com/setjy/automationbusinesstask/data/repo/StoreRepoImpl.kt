package com.setjy.automationbusinesstask.data.repo

import com.setjy.automationbusinesstask.data.remote.api.StoreApi
import com.setjy.automationbusinesstask.data.remote.response.StoreRemote
import com.setjy.automationbusinesstask.data.remote.response.toDomain
import com.setjy.automationbusinesstask.domain.model.Store
import com.setjy.automationbusinesstask.domain.repo.StoreRepo
import javax.inject.Inject

class StoreRepoImpl @Inject constructor(private val api: StoreApi) : StoreRepo {

    override suspend fun getStoreList(): List<Store> = api.getStoreList().map(StoreRemote::toDomain)
}