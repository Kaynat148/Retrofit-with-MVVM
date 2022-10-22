package com.maximus.task.Retrofit


import javax.inject.Inject


class DataRepository @Inject constructor(
    private val apiService: ApiService
){
    fun fetchData() = baseApiResultHandler {
        apiService.getFact()
    }
}