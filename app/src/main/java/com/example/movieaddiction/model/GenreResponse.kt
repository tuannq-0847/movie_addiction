package com.example.movieaddiction.model

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    val genres: MutableList<Genre> = mutableListOf()
)

data class Genre(
    @SerializedName("id")
    var idGenre: Int = 1,
    @SerializedName("name")
    var nameGenre: String = "default"
)
