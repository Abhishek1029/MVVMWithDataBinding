package com.abhishek.mvvmwithdatabinding.utils.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.abhishek.mvvmwithdatabinding.data.datasource.Dummy
import com.abhishek.mvvmwithdatabinding.data.datasource.Movies

class MovieDiffCallBack: DiffUtil.ItemCallback<Dummy>() {

    override fun areItemsTheSame(oldItem: Dummy, newItem: Dummy): Boolean {
        return oldItem.id ==newItem.id
    }

    override fun areContentsTheSame(oldItem: Dummy, newItem: Dummy): Boolean {

        return  oldItem==newItem
    }


}