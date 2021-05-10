package com.example.movieaddiction.data.source

import com.example.movieaddiction.api.MovieApi
import com.example.movieaddiction.model.BaseMovieResponse
import com.example.movieaddiction.model.MovieResult
import com.karleinstein.basemvvm.data.source.DataSource

class MovieDataSource constructor(
    private val movieApi: MovieApi
) : DataSource {

    suspend fun getPopularFilms(): BaseMovieResponse<MovieResult> = movieApi.getPopularFilms()

    suspend fun getTopRatedFilms(): BaseMovieResponse<MovieResult> = movieApi.getTopRatedFilms()

    suspend fun getPlayingFilms(): BaseMovieResponse<MovieResult> = movieApi.getPlayingFilms()

    suspend fun getVideoMovie() = movieApi.getVideoMovie()
}
