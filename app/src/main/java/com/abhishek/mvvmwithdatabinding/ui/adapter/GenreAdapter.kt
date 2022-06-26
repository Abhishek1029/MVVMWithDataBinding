package com.abhishek.mvvmwithdatabinding.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.mvvmwithdatabinding.databinding.SingleItemGenreBinding

class GenreAdapter : ListAdapter<String, GenreAdapter.GenreViewHolder>(GenreCallback()) {

    class GenreCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    inner class GenreViewHolder(val binding: SingleItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val mBinding =
            SingleItemGenreBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.binding.genreName = getItem(position)
    }
}