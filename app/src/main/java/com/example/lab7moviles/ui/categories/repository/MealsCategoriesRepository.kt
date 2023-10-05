package com.example.lab7moviles.ui.categories.repository

import com.example.lab7moviles.networking.MealsWeb
import com.example.lab7moviles.networking.response.MealResponseCategories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsCategoriesRepository(private val webService: MealsWeb = MealsWeb()){
    fun getMealCategories(successCallback: (response: MealResponseCategories?) -> Unit){
        return webService.getMealCategories().enqueue(object: Callback<MealResponseCategories> {
            override fun onResponse(
                call: Call<MealResponseCategories>,
                response: Response<MealResponseCategories>
            ){
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealResponseCategories>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
        )
    }
}