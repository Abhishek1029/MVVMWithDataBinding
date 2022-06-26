package com.abhishek.mvvmwithdatabinding.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.mvvmwithdatabinding.R
import com.abhishek.mvvmwithdatabinding.data.datasource.Movies
import com.abhishek.mvvmwithdatabinding.databinding.MovieAdapterItemBinding

private const val TAG = "MoviesAdapter"

class MoviesAdapter :ListAdapter<Movies,MoviesAdapter.MoviesViewHolder>(ListItemCallback()) {


    class ListItemCallback : DiffUtil.ItemCallback<Movies>() {
        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem== newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding: MovieAdapterItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_adapter_item, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movieData = getItem(position)
        Log.d("prine","${movieData.name} $position")
        holder.binding.apply {
            moviesData = movieData
        }
        holder.binding.layout1.tag=position

        holder.binding.layout1.setOnClickListener {
            Log.d("pos","${holder.binding.layout1.tag}")
        }
    }


    inner class MoviesViewHolder(val binding: MovieAdapterItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}