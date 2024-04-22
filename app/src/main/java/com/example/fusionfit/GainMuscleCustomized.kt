package com.example.fusionfit



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.fusionfit.ui.theme.headerColor

@Composable
fun GainMuscleCustomized(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "GainMuscleCustomized", fontSize = 30.sp, color = headerColor)
        }
    }
}
