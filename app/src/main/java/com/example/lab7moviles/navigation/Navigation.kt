package com.example.lab7moviles.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7moviles.ui.categories.view.MealCategoriesMainApp
import com.example.lab7moviles.ui.mealDetail.view.MealDetailMain
import com.example.lab7moviles.ui.meals.view.MealFilterMainApp

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.MealCategoriesMain.route,
        modifier = modifier) {
        composable(route = NavigationState.MealCategoriesMain.route) {
            MealCategoriesMainApp(navController)
        }
        composable(route = NavigationState.MealFilterMain.route) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("categoryId")
            if (category != null) {

                MealFilterMainApp(category,navController)
            }
        }
        composable(route = NavigationState.MealDetailsMain.route) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                MealDetailMain(mealId)
            }
        }
    }
}