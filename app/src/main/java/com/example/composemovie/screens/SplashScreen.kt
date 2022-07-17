package com.example.composemovie.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composemovie.navigation.Screens
import com.example.composemovie.ui.theme.ComposeMovieTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var startAnimate by remember { mutableStateOf(false) }
    val alphaAnimation =
        animateFloatAsState(
            targetValue = if (startAnimate) 1f else 0f,
            animationSpec = tween(durationMillis = 1000)
        )
    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(4000)
        navController.navigate(Screens.Main.route)
    }
    Splash(alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.ShoppingCart,
            tint = Color.Black,
            contentDescription = ""
        )
    }
}

@Composable
@Preview(showBackground = true)
fun prevSplash() {
    ComposeMovieTheme() {
        Splash(1f)
    }
}
