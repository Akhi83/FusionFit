package com.example.fusionfit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun GainMuscleCustomized(modifier: Modifier = Modifier,navController: NavController,images: List<Int>) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(bottom = 70.dp).padding(top = 60.dp)) {
        items(images) { image ->
            // Determine the destination screen based on the image ID
            val destination = when (image) {
                R.drawable.card6 -> Screens.MuscleBuildingExercises.screens
                R.drawable.card1 -> Screens.MuscleGainVeg.screens
                R.drawable.card2 -> Screens.MuscleGainVeg.screens
                else -> "YourDefaultScreen" // Default destination if image ID doesn't match any known screen
            }
            ImageItemForGainMuscleCustomized(image = image, navController = navController, destination = destination)
            Spacer(modifier = Modifier.height(8.dp))
        }

    }

}



@Composable
fun ImageItemForGainMuscleCustomized(image: Int, navController: NavController, destination: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .padding(top = 10.dp)
            .clickable {
                // Navigate to the specified destination when the card is clicked
                navController.navigate(destination)
            },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}