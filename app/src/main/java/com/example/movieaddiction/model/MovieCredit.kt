package com.example.movieaddiction.model

import com.google.gson.annotations.SerializedName

data class MovieCredit(
    @SerializedName("cast")
    var movieResult: MutableList<MovieResult> = mutableListOf()
)
