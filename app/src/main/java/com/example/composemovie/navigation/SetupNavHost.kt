package com.example.composemovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.Main.route) {
            MainScreen()
        }
        composable(route = Screens.Details.route) {}
    }
}
