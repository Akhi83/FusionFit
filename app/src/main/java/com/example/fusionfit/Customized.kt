package com.example.fusionfit



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fusionfit.ui.theme.FusionFitTheme

@Composable
fun Customized(navController: NavController) {
    val muscleImageResourceId = R.drawable.weight
    val weightImageResourceId = R.drawable.muscle
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "What's your goal?", style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(50.dp))
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable {navController.navigate(Screens.GainMuscleCustomized.screens)}

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = muscleImageResourceId),
                    contentDescription = "Gain Muscle",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Gain Muscle")
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable {navController.navigate(Screens.LoseMuscleCustomized.screens)}
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = weightImageResourceId),
                    contentDescription = "Lose Weight",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Lose Weight")
            }
        }
    }
}

//@Preview
//@Composable
//fun CustomizedPrev(){
//    FusionFitTheme {
//        Customized()
//    }
//}