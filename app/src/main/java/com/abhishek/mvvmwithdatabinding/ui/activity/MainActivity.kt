package com.abhishek.mvvmwithdatabinding.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhishek.mvvmwithdatabinding.R
import com.abhishek.mvvmwithdatabinding.data.datasource.Dummy
import com.abhishek.mvvmwithdatabinding.data.datasource.MovieData
import com.abhishek.mvvmwithdatabinding.data.datasource.Movies
import com.abhishek.mvvmwithdatabinding.databinding.ActivityMainBinding
import com.abhishek.mvvmwithdatabinding.ui.adapter.MoviesAdapter
import com.abhishek.mvvmwithdatabinding.ui.viewmodel.ActivityMainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    private val mainViewModel: ActivityMainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.moviesModel =mainViewModel
        mainViewModel.getMovieList()
        mainViewModel.movieData.observe(this){
            val moviesAdapter = MoviesAdapter()
            mBinding.recyclerVIew.adapter = moviesAdapter
            moviesAdapter.submitList(it)
        }
    }
}