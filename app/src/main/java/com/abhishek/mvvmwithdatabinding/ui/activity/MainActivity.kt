package com.abhishek.mvvmwithdatabinding.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.abhishek.mvvmwithdatabinding.R
import com.abhishek.mvvmwithdatabinding.databinding.ActivityMainBinding
import com.abhishek.mvvmwithdatabinding.ui.adapter.MoviesAdapter
import com.abhishek.mvvmwithdatabinding.ui.viewmodel.ActivityMainViewModel
import dagger.hilt.android.AndroidEntryPoint

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
            val moviesAdapter = MoviesAdapter(this)
            mBinding.recyclerVIew.adapter = moviesAdapter
            moviesAdapter.submitList(it)
        }
    }
}