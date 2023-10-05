package com.example.lab7moviles.networking

import com.example.lab7moviles.networking.response.MealResponseCategories
import com.example.lab7moviles.networking.response.MealResponseFilter
import com.example.lab7moviles.networking.response.MealResponseLookup
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWeb {
    private lateinit var api : MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    fun getMealCategories(): Call<MealResponseCategories> {     // Función para obtener categorías de comidas
        return api.getMealCategories()
    }

    fun getMealsByCategory(category: String): Call<MealResponseFilter> {  // Función para obtener comidas por categoría
        return api.getMealsByCategory(category)
    }

    fun getMealById(mealId: String): Call<MealResponseLookup> { // Función para obtener detalles de una comida por su ID
        return api.getMealById(mealId)
    }
}