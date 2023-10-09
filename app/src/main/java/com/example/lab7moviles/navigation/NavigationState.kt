package com.example.lab7moviles.navigation

import androidx.compose.runtime.Composable

sealed class NavigationState(val route : String){
    object MealCategoriesMain: NavigationState("FirstScreen")
    object MealFilterMain: NavigationState("SecondScreen")
    object MealDetailsMain: NavigationState("ThirdScreen")
}

