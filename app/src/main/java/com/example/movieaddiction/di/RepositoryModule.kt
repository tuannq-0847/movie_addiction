package com.example.movieaddiction.di

import com.example.movieaddiction.api.MovieApi
import com.example.movieaddiction.data.repository.MovieRepository
import com.example.movieaddiction.data.source.MovieDataSource
import com.karleinstein.basemvvm.api.ApiService
import com.karleinstein.basemvvm.data.model.ApiParameter
import org.koin.dsl.module

val repositoryModule = module {
    single { MovieRepository(get()) }
}

val remoteDataSourceModule = module {
    single { MovieDataSource(get()) }
}

val apiModule = module {
    single { ApiService.create<MovieApi>("https://api.themoviedb.org/",
    apiParameter = arrayOf(
        ApiParameter(key = "api_key", name = "1f54bd990f1cdfb230adb312546d765d"),
        ApiParameter(key = "language", name = "en-US")
    )) }
}
