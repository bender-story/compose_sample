package com.example.compose_sample.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_sample.route.Screen


@Composable
fun LazyStaggeredGridSnippetFixed(navController: NavHostController) {
    val itemsList = listOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
    )
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(4.dp) // Adjust padding around the grid as needed
        ) {
            items(itemsList) { item ->
                Card(modifier = Modifier
                    .padding(4.dp)) { // Adjust padding for individual grid items
                    Text(text = item, modifier = Modifier.padding(16.dp))
                }
            }
        }
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Screen.ScreenFive.route) }) {
            Text(text = "Screen Five")
        }
    }

}
