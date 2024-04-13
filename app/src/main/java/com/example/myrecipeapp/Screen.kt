package com.example.myrecipeapp

// This is used so that we can store our different screens information accurately and avoid any typos or small bugs
// A sealed class is a class that can contain it's own type object inside it
sealed class Screen(val route: String) {
    data object RecipeScreen: Screen("recipeScreen")            // Object for recipe screen
    data object DetailScreen: Screen("detailScreen")            // Object for Detailed Category Screen
}