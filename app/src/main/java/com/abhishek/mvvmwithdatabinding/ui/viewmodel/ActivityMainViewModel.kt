package com.abhishek.mvvmwithdatabinding.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.mvvmwithdatabinding.data.datasource.Dummy
import com.abhishek.mvvmwithdatabinding.data.datasource.Movies
import com.abhishek.mvvmwithdatabinding.ui.repository.ActivityMainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ActivityMainViewModel"

@HiltViewModel
class ActivityMainViewModel @Inject constructor(private val repository: ActivityMainRepository) :
    ViewModel() {
    private val mutableMovieData: MutableLiveData<List<Movies>> = MutableLiveData()

    val movieData: LiveData<List<Movies>>
        get() = mutableMovieData

    fun getMovieList() {
        viewModelScope.launch {
            val response = repository.getMovies()
            if (response.isSuccessful) {
                mutableMovieData.value = response.body()
            } else {
                Log.e(TAG, "getMovieList: ${response.message()}")
            }
        }
    }
}