package com.example.lab7moviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
sealed class AppScreens(val route: String) {
    object categoryScreen : AppScreens("firstScreen")
    object mealsScreen : AppScreens("secondScreen")
    object mealsDetailScreen : AppScreens("thirdScreen")

}

