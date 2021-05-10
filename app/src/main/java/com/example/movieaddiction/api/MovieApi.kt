package com.example.movieaddiction.api

import com.example.movieaddiction.model.*
import com.karleinstein.basemvvm.api.ApiService
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi : ApiService {
    @GET("3/movie/popular")
    suspend fun getPopularFilms(): BaseMovieResponse<MovieResult>

    @GET("3/movie/top_rated")
    suspend fun getTopRatedFilms(): BaseMovieResponse<MovieResult>

    @GET("3/movie/now_playing")
    suspend fun getPlayingFilms(): BaseMovieResponse<MovieResult>

    @GET("3/genre/movie/list")
    suspend fun getGenreMovies(): GenreResponse

    @GET("3/movie/{id}/credits")
    suspend fun getCreditsByIdMovie(@Path("id") id: Int): DetailActorResponse

    @GET("3/search/multi")
    suspend fun getResultBySearch(@Query("query") query: String): BaseMovieResponse<SearchResult>

    @GET("3/movie/{id}/similar")
    suspend fun getSimilarsByIdMovie(@Path("id") id: Int): BaseMovieResponse<MovieResult>

    @GET("3/person/{id}")
    suspend fun getDetailActor(@Path("id") id: Int): DetailActor

    @GET("3/person/{id}/movie_credits")
    suspend fun getMovieCredit(@Path("id") id: Int): MovieCredit

    @GET("3/movie/{id}/videos")
    suspend fun getVideoMovie(@Path("id") id: Int = 460465): BaseMovieResponse<MovieVideo>
}
