package com.example.lab7moviles.data.source.remote

import com.example.lab7moviles.data.source.remote.dto.CategoriesDto
import com.example.lab7moviles.data.source.remote.dto.IngredientsDto
import com.example.lab7moviles.data.source.remote.dto.filtersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealsApi {
    @GET("Categories/")
    suspend fun getCategories(
        @Query("categories") categories: Int
    ): CategoriesDto

    @GET("filter/")

    suspend fun getMeals(
        @Query("c") c: Int
    ): filtersDto

    @GET("ingredients/{id}")

    suspend fun getIngredients(
        @Path("id") id : Int
    ): IngredientsDto
}