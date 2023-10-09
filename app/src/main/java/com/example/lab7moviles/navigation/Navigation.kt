package com.example.lab7moviles.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7moviles.ui.categories.view.MealCategoriesMainApp
import com.example.lab7moviles.ui.mealDetail.view.MealDetailMainApp
import com.example.lab7moviles.ui.meals.view.MealFilterMainApp

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.MealCategoriesMain.route,
        modifier = modifier) {
        composable(route = NavigationState.MealCategoriesMain.route) {
            MealCategoriesMainApp()
        }
        composable(route = NavigationState.MealFilterMain.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {

                MealFilterMainApp(categoryId, navController)
            }
        }
        composable(route = "${NavigationState.MealDetailsMain.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                MealDetailMainApp(mealId)
            }
        }
    }
}