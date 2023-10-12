package com.example.lab7moviles.ui.meals.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.lab7moviles.navigation.NavigationState
import com.example.lab7moviles.networking.response.Meals
import com.example.lab7moviles.ui.meals.viewModel.MealFilterViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign


@Composable
fun MealFilterMainApp(category: String?, navController: NavController) {
    val viewModel: MealFilterViewModel = viewModel()
    val filteredMeals: MutableState<List<Meals>> = remember { mutableStateOf(emptyList()) }
    val context = LocalContext.current
    val titleBackgroundColor = Color(0xFF006064)


    if (category != null) {
        viewModel.getMealsByCategory(category) { response ->
            val mealsFromTheApi = response?.meals.orEmpty()
            filteredMeals.value = mealsFromTheApi
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Available Meals",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(titleBackgroundColor)
            )

            LazyColumn {
                items(filteredMeals.value) { meal ->
                    MealItem(meal= meal, context= context, navController = navController)
                }
            }
        }
    }

}

@Composable
fun MealItem(meal: Meals, context: Context,navController: NavController) {

    val mealId = meal.idMeal
    val titleBackgroundColor = Color(0xFF0097A7)

    val brush = Brush.horizontalGradient(
        colors = listOf(titleBackgroundColor, titleBackgroundColor),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("${NavigationState.MealDetailsMain.route.replace("{mealId}", mealId)}")


            }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            val painter = rememberAsyncImagePainter(model = meal.imageUrlmeal)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .height(200.dp),

                        contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meal.stringMeal,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 14.dp)
                    .fillMaxWidth()
                    .background(titleBackgroundColor)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}