package com.example.movieaddiction.di

import com.example.movieaddiction.ui.composables.viewmodels.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ WelcomeViewModel() }
}