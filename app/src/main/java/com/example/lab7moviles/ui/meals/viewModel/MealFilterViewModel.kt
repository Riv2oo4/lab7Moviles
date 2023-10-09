package com.example.lab7moviles.ui.meals.viewModel

import androidx.lifecycle.ViewModel
import com.example.lab7moviles.networking.response.MealResponseFilter
import com.example.lab7moviles.ui.meals.repository.MealFilterRepository

class MealFilterViewModel(private val repository: MealFilterRepository = MealFilterRepository()) : ViewModel() {
    fun getMealsByCategory(
        category: String,
        successCallback: (response: MealResponseFilter?) -> Unit
    ) {
        repository.getMealByCategory(category) { response ->
            successCallback(response)
        }
    }
}