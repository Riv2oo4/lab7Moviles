package com.example.lab7moviles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab7moviles.navigation.Navigation
import com.example.lab7moviles.ui.categories.view.MealCategoriesMainApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealCategoriesMainApp()
        }

    }
}


