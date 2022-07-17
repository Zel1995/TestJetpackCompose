package com.example.composemovie.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composemovie.MainViewModel
import com.example.composemovie.screens.MainScreen
import com.example.composemovie.screens.SplashScreen
import com.example.composemovie.utils.Constants.Screens.DETAIL_SCREEN
import com.example.composemovie.utils.Constants.Screens.MAIN_SCREEN
import com.example.composemovie.utils.Constants.Screens.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object Splash : Screens(SPLASH_SCREEN)
    object Main : Screens(MAIN_SCREEN)
    object Details : Screens(DETAIL_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController, viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController,viewModel)
        }
        composable(route = Screens.Details.route) {}
    }
}
