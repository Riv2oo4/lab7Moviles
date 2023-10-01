package com.example.lab7moviles.network;

import com.example.lab7moviles.model.category;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMeal {
    @GET("api/json/v1/1/categories.php")
    Call<List<category>> getCategory();
}
