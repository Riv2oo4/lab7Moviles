package com.example.lab7moviles.ui.mealDetail.viewModel

import androidx.lifecycle.ViewModel
import com.example.lab7moviles.networking.response.MealResponseLookup
import com.example.lab7moviles.ui.mealDetail.repository.MealDetailRepository

class MealDetailViewModel {
}
class MealDetailsViewModel(private val repository: MealDetailRepository = MealDetailRepository()) : ViewModel() {
    fun getMealById(
        mealId: String,
        successCallback: (response: MealResponseLookup?) -> Unit
    ) {
        repository.getMealById(mealId) { response ->
            successCallback(response)
        }
    }
}