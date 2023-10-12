package com.example.lab7moviles.ui.categories.view

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.lab7moviles.navigation.NavigationState
import com.example.lab7moviles.networking.response.MealResponse
import com.example.lab7moviles.ui.categories.viewModel.MealCategoriesViewModel



@Composable
fun MealCategoriesMainApp(navController: NavController) {
    val viewModel: MealCategoriesViewModel = viewModel()
    val categorizedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList<MealResponse>()) }
    val context = LocalContext.current
    val titleBackgroundColor = Color(0xFF006064)

    val brush = Brush.horizontalGradient(
        colors = listOf(titleBackgroundColor, titleBackgroundColor),
        )


    viewModel.getMealCategories { response ->
        val mealsFromTheApi = response?.categories
        categorizedMeals.value = mealsFromTheApi.orEmpty()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meal Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(titleBackgroundColor )
        )

        LazyColumn {
            items(categorizedMeals.value) { meal ->
                CategoryItem(meal = meal,  context, navController =  navController)
            }
        }
    }
}

@Composable
fun CategoryItem(meal: MealResponse, context: Context, navController: NavController) {
    val arrowDownIcon = Icons.Default.KeyboardArrowDown
    val arrowUpIcon = Icons.Default.KeyboardArrowUp
    val titleBackgroundColor = Color(0xFF0097A7)

    var isDescriptionVisible by remember { mutableStateOf(false) }
    val category = meal.name

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                isDescriptionVisible = !isDescriptionVisible


            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val painter = rememberAsyncImagePainter(model = meal.imageUrl)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable{
                        navController.navigate("${NavigationState.MealFilterMain.route.replace("{categoryId}", category)}")



                    },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = meal.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(titleBackgroundColor)
            )

            Divider(
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp))

            if (isDescriptionVisible) {
                Text(
                    text = meal.description,
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Icon(imageVector = arrowUpIcon, contentDescription = null)
            } else {
                Icon(imageVector = arrowDownIcon, contentDescription = null)
            }
        }
    }
}
