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

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {      // It contains all information about screens in our app and their connectivity with each other
        composable(Screen.RecipeScreen.route) {// Composable for recipe screen
            RecipeScreen(viewState = viewState,
                navigateToDetail = {category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat",category)   // Storing the category item that we get after clicking an category image from recipe screen in the currentBackStackEntry using a key-value pair
                    navController.navigate(Screen.DetailScreen.route)
                }
            )
        }
        composable(Screen.DetailScreen.route) {// Composable for detailed category screen
            // Retrieving the previously stored category item from the previousBackStackEntry using our key that we set on previous screen
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }
}