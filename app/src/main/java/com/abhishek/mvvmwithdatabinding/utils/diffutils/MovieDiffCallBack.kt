package com.abhishek.mvvmwithdatabinding.utils.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.abhishek.mvvmwithdatabinding.data.datasource.Movies

class MovieDiffCallBack: DiffUtil.ItemCallback<Movies>() {

    override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
        return oldItem.name ==newItem.name
    }

    override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {

        return  oldItem==newItem
    }


}