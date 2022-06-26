package com.abhishek.mvvmwithdatabinding.ui.repository

import com.abhishek.mvvmwithdatabinding.utils.networkcalls.ApiInterface
import javax.inject.Inject

class ActivityMainRepository @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getMovies() = apiInterface.getMovies()
}