package com.example.myrecipeapp

// Data class for storing category information
data class Category(
    val idCategory: String,         // Category id
    val strCategory: String,        // Category name
    val strCategoryThumb: String,   // Category Thumbnail
    val strCategoryDescription: String  // Category Description
)

// Data class for storing list given by JSON file
data class CategoriesResponse(
    val categories: List<Category>
)