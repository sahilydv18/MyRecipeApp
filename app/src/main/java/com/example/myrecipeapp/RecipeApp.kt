package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()            // View Model Instance
    val viewState by recipeViewModel.categoriesState            // Using the categoriesState created in viewModel to update it on the screen

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState,
                navigateToDetail = {category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat",category)
                    navController.navigate(Screen.DetailScreen.route)
                }
            )
        }
        composable(Screen.DetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }
}