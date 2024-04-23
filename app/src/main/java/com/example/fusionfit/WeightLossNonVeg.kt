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
fun WeightLossNonVeg() {
    Column (modifier = Modifier.padding(top = 30.dp)){
        Image(painter = painterResource(id=R.drawable.fatloss), contentDescription =null,modifier=Modifier.fillMaxWidth())
        DietlistWeightLossNonVeg()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetWeightLossNonVeg(selectedWorkout:DietItemWeightLossNonVeg?,onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column() {
            if (selectedWorkout != null) {
                Text(text = selectedWorkout.name,modifier=Modifier.padding(10.dp).align(Alignment.CenterHorizontally), fontSize = 25.sp,fontWeight = FontWeight.Bold)
                if (selectedWorkout.name == "Breakfast"){
                    Image(painter = painterResource(id = R.drawable.bf), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Lunch"){
                    Image(painter = painterResource(id = R.drawable.lnch), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Pre-workout"){
                    Image(painter = painterResource(id = R.drawable.prew), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Post-workout"){
                    Image(painter = painterResource(id = R.drawable.postw), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
                if (selectedWorkout.name == "Dinner"){
                    Image(painter = painterResource(id = R.drawable.dinn), contentDescription =null,modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                }
            }
        }
    }
}
@Composable
fun LoadImagetWeightLossNonVeg(storage:Int){
    Image(painter = painterResource(id = storage), contentDescription = null,modifier=Modifier.size(150.dp))
}
val dietitemsWeightLossNonVeg= listOf(
    DietItemWeightLossNonVeg("Breakfast",R.drawable.breakfasts),
    DietItemWeightLossNonVeg("Lunch",R.drawable.lunch),
    DietItemWeightLossNonVeg("Pre-workout",R.drawable.preworkoutfood),
    DietItemWeightLossNonVeg("Post-workout",R.drawable.postworkoutfood),
    DietItemWeightLossNonVeg("Dinner",R.drawable.dinners)
)
@Composable
fun DietlistWeightLossNonVeg(){
    var showSheet by remember { mutableStateOf(false) }
    var selectedDiet by remember { mutableStateOf<DietItemWeightLossNonVeg?>(null) }

    if (showSheet) {
        BottomSheetWeightLossNonVeg(selectedDiet) {
            showSheet = false
        }
    }
    LazyColumn (contentPadding = PaddingValues(bottom = 56.dp)) {
        items(dietitemsWeightLossNonVeg.size) { item ->
            val item= dietitemsWeightLossNonVeg[item]
            Row(modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .clickable { showSheet = true;selectedDiet = item }) {
                LoadImagetWeightLossNonVeg(item.imageStorageReference)
                Text(item.name,modifier= Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp), fontSize = 18.sp)
            }
        }
    }
}
data class DietItemWeightLossNonVeg(val name: String, val imageStorageReference: Int)