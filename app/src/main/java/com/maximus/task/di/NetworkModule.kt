package com.maximus.task.di

import com.maximus.task.Retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}