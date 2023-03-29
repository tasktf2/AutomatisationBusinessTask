package com.setjy.automationbusinesstask.domain.repo

import com.setjy.automationbusinesstask.domain.model.Store

interface StoreRepo {

  suspend  fun getStoreList(): List<Store>
}