package com.abhishek.mvvmwithdatabinding.data.datasource

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movies(
    @SerializedName("actors") val actors: ArrayList<String>,
    @SerializedName("desc") val desc: String,
    @SerializedName("directors") val directors: ArrayList<String>,
    @SerializedName("genre") val genre: ArrayList<String>,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("thumb_url") val thumbUrl: String,
    @SerializedName("imdb_url") val imdbUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("year") val year: Int
) : Serializable
