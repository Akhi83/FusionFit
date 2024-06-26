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
fun WeightLossVeg() {
    Column (modifier = Modifier.padding(top = 30.dp)){
        Image(painter = painterResource(id=R.drawable.fatlossveg), contentDescription =null,modifier=Modifier.fillMaxWidth())
        DietlistWeightLossVeg()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetWeightLossVeg(selectedWorkout:DietItemWeightLossVeg?,onDismiss: () -> Unit) {
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
                    Image(painter = painterResource(id = R.drawable.vegbffatloss), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Lunch"){
                    Image(painter = painterResource(id = R.drawable.veglnchfatloss), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Pre-workout"){
                    Image(painter = painterResource(id = R.drawable.vegprewfatloss), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Post-workout"){
                    Image(painter = painterResource(id = R.drawable.vegpostwfatloss), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Dinner"){
                    Image(painter = painterResource(id = R.drawable.vegdinnfatloss), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
            }
        }
    }
}
@Composable
fun LoadImageWeightLossVeg(storage:Int){
    Image(painter = painterResource(id = storage), contentDescription = null,modifier=Modifier.size(150.dp))
}
val dietitemsWeightLossVeg= listOf(
    DietItemWeightLossVeg("Breakfast",R.drawable.breakfasts),
    DietItemWeightLossVeg("Lunch",R.drawable.lunch),
    DietItemWeightLossVeg("Pre-workout",R.drawable.preworkoutfood),
    DietItemWeightLossVeg("Post-workout",R.drawable.postworkoutfood),
    DietItemWeightLossVeg("Dinner",R.drawable.dinners)
)
@Composable
fun DietlistWeightLossVeg(){
    var showSheet by remember { mutableStateOf(false) }
    var selectedDiet by remember { mutableStateOf<DietItemWeightLossVeg?>(null) }

    if (showSheet) {
        BottomSheetWeightLossVeg(selectedDiet) {
            showSheet = false
        }
    }
    LazyColumn (contentPadding = PaddingValues(bottom = 56.dp)) {
        items(dietitemsWeightLossVeg.size) { item ->
            val item= dietitemsWeightLossVeg[item]
            Row(modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .clickable { showSheet = true;selectedDiet = item }) {
                LoadImageWeightLossVeg(item.imageStorageReference)
                Text(item.name,modifier= Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp), fontSize = 18.sp)
            }
            HorizontalDivider()
        }
    }
}
data class DietItemWeightLossVeg(val name: String, val imageStorageReference: Int)