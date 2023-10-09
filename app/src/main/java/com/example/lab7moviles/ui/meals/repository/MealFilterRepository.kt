package com.example.lab7moviles.ui.meals.repository

import com.example.lab7moviles.networking.MealsWeb
import com.example.lab7moviles.networking.response.MealResponseFilter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealFilterRepository(private val webService: MealsWeb= MealsWeb()) {
    fun getMealByCategory(category: String, successCallback: (response: MealResponseFilter?) -> Unit){
        return webService.getMealsByCategory(category).enqueue(object: Callback<MealResponseFilter>{
            override fun onResponse(
                call: Call<MealResponseFilter>,
                response: Response<MealResponseFilter>
            ){
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealResponseFilter>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
        )
    }
}