package com.example.movieaddiction.ui.composables.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieaddiction.ui.composables.screen.HomeScreen
import com.example.movieaddiction.ui.composables.screen.LoginScreen
import com.example.movieaddiction.ui.composables.screen.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MovieAddictionScreen.WELCOME_ROUTE.name
    ) {
        composable(MovieAddictionScreen.WELCOME_ROUTE.name) {
            WelcomeScreen(navController = navController)
        }
        composable(MovieAddictionScreen.LOGIN_ROUTE.name) {
            LoginScreen(navController = navController)
        }
        composable(MovieAddictionScreen.HOME_ROUTE.name) {
            HomeScreen(navHostController = navController)
        }
    }
}
