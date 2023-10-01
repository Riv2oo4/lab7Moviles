package com.example.lab7moviles.screens.category

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    Scaffold {
        BodyContent(navController)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContent(navController: NavController) {
    // Aquí puedes colocar el contenido de la pantalla de listado de categorías
    // Utiliza LazyColumn para mostrar la lista de categorías y navegar a la pantalla de filtrado por categoría

    // Ejemplo de uso de LazyColumn para mostrar la lista de categorías
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category) {
                // Navegar a la pantalla de filtrado por categoría
                navController.navigate("category/${category.idCategory}")
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category, onItemClick: () -> Unit) {
    // Aquí defines el diseño de cada elemento de la lista de categorías
    // Puedes utilizar Card, Column, Text, Image, etc., según tu diseño
    // Llama a onItemClick cuando se haga clic en un elemento

    // Ejemplo de diseño simple con un Card y Text
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onItemClick),

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = category.strCategory,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            // Aquí puedes mostrar más información sobre la categoría si es necesario
        }
    }
}

// Modelo de datos para la categoría
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

// Lista de categorías de ejemplo (puedes reemplazarla con los datos reales de la API)
val categories = listOf(
    Category("1", "Beef", "https://www.themealdb.com/images/category/beef.png", "Description 1"),
    Category("2", "Chicken", "https://www.themealdb.com/images/category/chicken.png", "Description 2"),
    // ... Añade más categorías según sea necesario
)
