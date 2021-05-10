package com.example.movieaddiction.data.repository

import com.example.movieaddiction.data.source.MovieDataSource
import com.example.movieaddiction.model.BaseMovieResponse
import com.example.movieaddiction.model.MovieResult
import com.karleinstein.basemvvm.data.source.DataSource

class MovieRepository(private val movieDataSource: MovieDataSource) {

    suspend fun getPopularFilms(): BaseMovieResponse<MovieResult> =
        movieDataSource.getPopularFilms()

    suspend fun getTopRatedFilms(): BaseMovieResponse<MovieResult> =
        movieDataSource.getTopRatedFilms()

    suspend fun getPlayingFilms(): BaseMovieResponse<MovieResult> =
        movieDataSource.getPlayingFilms()

    suspend fun getVideoMovie() = movieDataSource.getVideoMovie()
}
