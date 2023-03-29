package com.setjy.automationbusinesstask.domain.base

interface UseCase<Params, T> {

    suspend fun execute(params: Params): T
}