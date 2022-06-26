package com.abhishek.mvvmwithdatabinding.utils.networkcalls

import com.abhishek.mvvmwithdatabinding.data.datasource.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("top250_min.json")
    suspend fun getMovies(): Response<List<Movies>>
}