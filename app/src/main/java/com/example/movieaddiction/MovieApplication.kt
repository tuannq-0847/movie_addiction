package com.example.movieaddiction

import com.example.movieaddiction.di.apiModule
import com.example.movieaddiction.di.remoteDataSourceModule
import com.example.movieaddiction.di.repositoryModule
import com.example.movieaddiction.di.viewModelModule
import com.karleinstein.basemvvm.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MovieApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@MovieApplication)
            // use modules
            modules(viewModelModule, repositoryModule, remoteDataSourceModule, apiModule)
        }
    }
}
