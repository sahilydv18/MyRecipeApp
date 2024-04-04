package com.example.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _categoryState = mutableStateOf(RecipeState())      // State for displaying categories
    val categoriesState: State<RecipeState> = _categoryState        // variable that can be used for accessing state as it is private for abstraction

    init {      // running fetchCategories() whenever our viewModel is used
        fetchCategories()
    }

    private fun fetchCategories() {         // function for getting categories from the API service we created
        viewModelScope.launch { // This is a coroutine scope or a viewModelScope - it enables us to execute the code on a background thread
            try {
                // If there is no exception we are updating our list with the list we get from the API service(recipe service), and setting the loading to false
                val response = recipeService.getCategories()        // Storing the object that contains CategoryList into this
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    list = response.categories,         // Storing the categories list here
                    error = null
                )
            } catch (e: Exception) {
                // If there is an exception we are updating the error message and stopping the loading
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

    // Data class used for storing that if the categories are loaded successfully or is there an error or are they still loading
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}