package com.example.lab7moviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7moviles.screens.category.FirstScreen
import com.example.lab7moviles.screens.meals.SecondScreen
import com.example.lab7moviles.screens.mealsDetail.ThirdScreen



@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController =navController,startDestination =AppScreens.categoryScreen.route){
        composable(route = AppScreens.categoryScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.mealsScreen.route){
            SecondScreen(navController)
        }
        composable(route = AppScreens.mealsDetailScreen.route){
            ThirdScreen(navController)
        }

    }
}