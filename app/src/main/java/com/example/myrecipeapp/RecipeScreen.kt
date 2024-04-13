package com.example.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, navigateToDetail: (Category) -> Unit, viewState: MainViewModel.RecipeState) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                // When we are loading then displaying a circular loader
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                // If an error occurs this is displayed
                Text(text = "Error Occurred")
            }

            else -> {
                // Display Categories
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}

// How the category grid looks like
@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetail: (Category) -> Unit) {
    // Just like lazy column this is also used and it updates its content based on what the user is seeing
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) {
            CategoryItem(category = it, navigateToDetail)
        }
    }
}

// How each category item looks like
@Composable
fun CategoryItem(category: Category, navigateToDetail:(Category) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable { navigateToDetail(category) },          // This is used to make a composable acts like a clickable button, every composable have this property
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Used this to display image of category
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .aspectRatio(1f)       // aspectRatio -> 1f means the image should have same height and width
        )

        // Used this to display name of category
        Text(
            text = category.strCategory,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}