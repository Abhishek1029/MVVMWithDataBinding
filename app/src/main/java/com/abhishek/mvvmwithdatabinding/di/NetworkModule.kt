package com.abhishek.mvvmwithdatabinding.di

import com.abhishek.mvvmwithdatabinding.utils.networkcalls.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesBaseUrl(): String = "https://raw.githubusercontent.com/theapache64/top250/master/"

    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesRetrofitInstance(
        baseUrl: String,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun providesApiInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

}