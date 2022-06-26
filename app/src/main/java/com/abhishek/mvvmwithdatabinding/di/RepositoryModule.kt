package com.abhishek.mvvmwithdatabinding.di

import com.abhishek.mvvmwithdatabinding.ui.repository.ActivityMainRepository
import com.abhishek.mvvmwithdatabinding.utils.networkcalls.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesActivityMainRepository(apiInterface: ApiInterface): ActivityMainRepository {
        return ActivityMainRepository(apiInterface = apiInterface)
    }
}