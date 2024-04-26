package com.example.fusionfit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fusionfit.data.SignUpViewModel


@Composable
fun PageIndicator(pageCount: Int, currentPage: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentWidth()
        ) {
            repeat(pageCount) { index ->
                val color = if (index == currentPage) Color.Black else Color.Gray
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(color = color, shape = CircleShape)
                )
            }
        }
    }
}



@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(modifier: Modifier = Modifier,navController: NavController, quotes: List<String>,images: List<Int>,signUpViewModel: SignUpViewModel) {
    val pagerState = rememberPagerState(pageCount = quotes.size)
    val scope = rememberCoroutineScope()

    // Automatically switch to the next quote
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            scope.launch {
                pagerState.animateScrollToPage(nextPage) //Gives animated effect of sliding the quotes
//                pagerState.scrollToPage(nextPage)  // doesn't give the animated effect of sliding the quotes
            }
        }
    }



    LazyColumn(modifier = modifier.fillMaxSize().padding(bottom = 75.dp)) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 95.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) { currentPage ->
                    QuoteCard(quote = quotes[currentPage], onClick = { /* Handle click */ })
                }

                PageIndicator(pageCount = quotes.size, currentPage = pagerState.currentPage)
            }

            Text(text = "Featured", fontSize = 30.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp))

        }
        items(images) { image ->
            // Determine the destination screen based on the image ID
            val destination = when (image) {
                R.drawable.card1 -> Screens.MuscleGainVeg.screens
                R.drawable.card2 -> Screens.MuscleGainNonVeg.screens
                R.drawable.stretching_card -> Screens.Cardio.screens
                R.drawable.card4 -> Screens.WeightLossExercises.screens
                R.drawable.card5 -> Screens.WeightLossNonVeg.screens
                R.drawable.card7 -> Screens.WeightLossVeg.screens
                R.drawable.card6 -> Screens.MuscleBuildingExercises.screens
                else -> "YourDefaultScreen" // Default destination if image ID doesn't match any known screen
            }
            ImageItem(image = image, navController = navController, destination = destination)
            Spacer(modifier = Modifier.height(8.dp))
        }

    }

}




@Composable
fun QuoteCard(quote: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick), // Make the card clickable
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Text(text = quote)
        }
    }
}


@Composable
fun ImageItem(image: Int, navController: NavController, destination: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
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






//@Preview
//@Composable
//fun showPreviewHome(){
//    val imageIds = listOf(
//        R.drawable.card1,
//        R.drawable.card2,
//        R.drawable.stretching_card,
//        R.drawable.card4,
//        R.drawable.card5,
//        R.drawable.card6
//    )
//    FusionFitTheme {
//        Home(quotes = listOf("The only bad workout is the one that didn't happen", "Success isn't given. It's earned. On the track, on the field, in the gym. With blood, sweat, and the occasional tear", "The pain you feel today will be the strength you feel tomorrow", "The only way to define your limits is by going beyond them"),images=imageIds)
//
//    }
//}