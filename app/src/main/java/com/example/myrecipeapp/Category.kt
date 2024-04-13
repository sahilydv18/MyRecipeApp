package com.example.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Data class for storing category information
@Parcelize
data class Category(
    val idCategory: String,         // Category id
    val strCategory: String,        // Category name
    val strCategoryThumb: String,   // Category Thumbnail
    val strCategoryDescription: String  // Category Description
): Parcelable

// Data class for storing list given by JSON file
data class CategoriesResponse(
    val categories: List<Category>
)