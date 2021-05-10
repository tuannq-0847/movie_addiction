package com.example.movieaddiction.model

import com.google.gson.annotations.SerializedName

data class MovieVideo(
    val id: String,
    @SerializedName("iso_639_1")
    val iso639: String,
    @SerializedName("iso_3166_1")
    val iso3166: String,
    val key: String,
    val name: String,
    val site: String,
    val size: Int,
    val type: String
)
