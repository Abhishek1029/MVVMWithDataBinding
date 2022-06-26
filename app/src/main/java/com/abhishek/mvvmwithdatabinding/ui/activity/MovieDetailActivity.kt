package com.abhishek.mvvmwithdatabinding.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.abhishek.mvvmwithdatabinding.R
import com.abhishek.mvvmwithdatabinding.data.datasource.Movies
import com.abhishek.mvvmwithdatabinding.databinding.ActivityMovieDetailBinding
import com.abhishek.mvvmwithdatabinding.ui.adapter.GenreAdapter

private const val TAG = "MovieDetailActivity"

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMovieDetailBinding
    private var movie: Movies? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        movie = intent.getSerializableExtra("movie") as Movies?
        Log.e(TAG, "onCreate: ${movie?.name ?: "Null Aaya hai"}")
        mBinding.apply {
            movieData = movie
            val genreAdapter = GenreAdapter()
            genreRV.adapter = genreAdapter
            genreAdapter.submitList(movie?.genre)
        }
    }
}