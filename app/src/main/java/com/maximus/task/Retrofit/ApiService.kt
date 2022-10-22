package com.maximus.task.Retrofit


import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/fact")
    suspend  fun getFact(): Response<Fact?>
}