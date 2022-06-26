package com.abhishek.mvvmwithdatabinding.utils.extensions

import android.net.Uri
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("displayImage")
fun SimpleDraweeView.displayImage(url: String) {
    setImageURI(Uri.parse(url));
}