package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Used retrofit to get the file from themealdb and converting the JSON file into Kotlin object using GsonConvertorFactory
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").
        addConverterFactory(GsonConverterFactory.create()).
        build()

// used the retrofit variable created above to create our recipeApp Service
val recipeService = retrofit.create(ApiService::class.java)

// Interface for API Service
interface ApiService {
    @GET("categories.php")      // Getting the categories.php file from themealdb
    suspend fun getCategories():CategoriesResponse      // Give a list of categories
}