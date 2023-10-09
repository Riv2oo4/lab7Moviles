package com.example.lab7moviles.networking

import com.example.lab7moviles.networking.response.MealResponseCategories
import com.example.lab7moviles.networking.response.MealResponseFilter
import com.example.lab7moviles.networking.response.MealResponseLookup
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {

    @GET("categories.php")
    fun getMealCategories(): Call<MealResponseCategories>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") category:String): Call<MealResponseFilter>

    @GET("lookup.php")
    fun getMealById(@Query("i") mealId:String): Call<MealResponseLookup>
}