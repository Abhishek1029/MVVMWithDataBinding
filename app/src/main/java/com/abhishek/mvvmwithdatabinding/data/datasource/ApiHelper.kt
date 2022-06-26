package com.abhishek.mvvmwithdatabinding.data.datasource

import com.abhishek.mvvmwithdatabinding.utils.networkcalls.ApiInterface
import retrofit2.Response

interface ApiHelper {
    suspend fun getMovies(): Response<List<Movies>>
}

class ApiHelperImpl(private val apiInterface: ApiInterface) : ApiHelper {
    override suspend fun getMovies() = apiInterface.getMovies()
}