package com.example.movieaddiction.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieaddiction.ui.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ WelcomeViewModel() }
}