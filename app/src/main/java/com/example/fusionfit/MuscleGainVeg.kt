package com.example.fusionfit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MuscleGainVeg(){
    Column (modifier = Modifier.padding(top = 30.dp)){
        Image(painter = painterResource(id=R.drawable.card1), contentDescription =null,modifier=Modifier.fillMaxWidth())
        DietlistMuscleGainVeg()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetMuscleGainVeg(selectedWorkout:DietItemMuscleGainVeg?,onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column() {
            if (selectedWorkout != null) {
                Text(text = selectedWorkout.name,modifier= Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally), fontSize = 25.sp,fontWeight = FontWeight.Bold)
                if (selectedWorkout.name == "Breakfast"){
                    Image(painter = painterResource(id = R.drawable.vegbfmuscle), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Lunch"){
                    Image(painter = painterResource(id = R.drawable.veglnchmuscle), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Pre-workout"){
                    Image(painter = painterResource(id = R.drawable.vegprewmuscle), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Post-workout"){
                    Image(painter = painterResource(id = R.drawable.vegpostwmuscle), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Dinner"){
                    Image(painter = painterResource(id = R.drawable.vegdinnmuscle), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
            }
        }
    }
}
@Composable
fun LoadImageMuscleGainVeg(storage:Int){
    Image(painter = painterResource(id = storage), contentDescription = null,modifier=Modifier.size(150.dp))
}
val dietitemsMuscleGainVeg= listOf(
    DietItemMuscleGainVeg("Breakfast",R.drawable.breakfasts),
    DietItemMuscleGainVeg("Lunch",R.drawable.lunch),
    DietItemMuscleGainVeg("Pre-workout",R.drawable.preworkoutfood),
    DietItemMuscleGainVeg("Post-workout",R.drawable.postworkoutfood),
    DietItemMuscleGainVeg("Dinner",R.drawable.dinners)
)
@Composable
fun DietlistMuscleGainVeg(){
    var showSheet by remember { mutableStateOf(false) }
    var selectedDiet by remember { mutableStateOf<DietItemMuscleGainVeg?>(null) }

    if (showSheet) {
        BottomSheetMuscleGainVeg(selectedDiet) {
            showSheet = false
        }
    }
    LazyColumn (contentPadding = PaddingValues(bottom = 56.dp)) {
        items(dietitemsMuscleGainVeg.size) { item ->
            val item= dietitemsMuscleGainVeg[item]
            Row(modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .clickable { showSheet = true;selectedDiet = item }) {
                LoadImageMuscleGainVeg(item.imageStorageReference)
                Text(item.name,modifier= Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp), fontSize = 18.sp)
            }
            HorizontalDivider()
        }
    }
}
data class DietItemMuscleGainVeg(val name: String, val imageStorageReference: Int)