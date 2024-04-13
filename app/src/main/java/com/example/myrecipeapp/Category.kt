package com.example.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
id("kotlin-parcelize") - Dependency is used inside plugins in build.gradle.app
@Parcelize helps to serialize and deserialize an object
Serializing an object helps us to pass an object from one screen to another in a format that is used by our backStackEntry to pass objects
And Deserializing an object makes our formatted object back into the object that we are passing to the next screen
*/
@Parcelize
data class Category(                // Data class for storing category information
    val idCategory: String,         // Category id
    val strCategory: String,        // Category name
    val strCategoryThumb: String,   // Category Thumbnail
    val strCategoryDescription: String  // Category Description
): Parcelable

// Data class for storing list given by JSON file
data class CategoriesResponse(
    val categories: List<Category>
)