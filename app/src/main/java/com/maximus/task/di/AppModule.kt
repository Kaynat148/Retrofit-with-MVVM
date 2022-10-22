package com.maximus.task.di

import com.maximus.task.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {

        val client = OkHttpClient.Builder()

        client.interceptors().add(Interceptor { chain: Interceptor.Chain ->
            var request = chain.request()
            request = request
                .newBuilder()
                .build()
            chain.proceed(request)
        })

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }




}