package com.example.lab7moviles.ui.categories.viewModel

import androidx.lifecycle.ViewModel
import com.example.lab7moviles.networking.response.MealResponseCategories
import com.example.lab7moviles.ui.categories.repository.MealsCategoriesRepository

class MealCategoriesViewModel(private val repository: MealsCategoriesRepository = MealsCategoriesRepository()): ViewModel(){
    fun getMealCategories(successCallback: (response: MealResponseCategories?) -> Unit){
        repository.getMealCategories{response ->
            successCallback(response)
        }
    }
}