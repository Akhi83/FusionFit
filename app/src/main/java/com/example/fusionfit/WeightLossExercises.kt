package com.example.fusionfit

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import kotlin.math.ceil

@Composable
fun  WeightLossExercises() {
    Box {
        Column(modifier = Modifier.padding(top = 42.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card4),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(text = "10 mins-10 workouts(15s rest between each workout)", modifier = Modifier.padding(5.dp), fontSize = 17.sp,fontWeight = FontWeight.Bold)
            HorizontalDivider()
            WorkoutListWeightLoss()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetWeightLoss(selectedWorkout:WorkoutItem?,onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column(){
            if (selectedWorkout != null) {
                Text("${selectedWorkout.name}",modifier=Modifier.padding(10.dp), fontSize = 25.sp,fontWeight = FontWeight.Bold)
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                    LoadImageWeightLoss(selectedWorkout.imageStorageReference, 300.dp)
                }
                Row (modifier=Modifier.padding(10.dp)) {
                    Text("DURATION",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text("${selectedWorkout.time}")
                }
                if (selectedWorkout.name == "But Kicks"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Start with a high knee run in place, focusing on kicking your heels up towards your glutes with each step. Maintain a quick and controlled pace," +
                                    " keeping your core engaged and back straight. Avoid arching your back and concentrate on driving the movement from your hamstrings."
                        )
                        val muscleGroups = listOf(
                            "Glutes", "Hamstrings"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Burpees"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Squat down and place your hands flat on the floor in front of you. Kick your legs back into a push-up position (modify to a knee push-up if needed). Quickly jump your legs back in and stand tall," +
                                    " explosively jumping up with your arms raised overhead. Maintain control throughout the movement and breathe deeply. "
                        )
                        val muscleGroups = listOf(
                            "Quads", "Hamstrings", "Glutes", "Chest", "Shoulders", "Triceps"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Jumping Jacks"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall with feet hip-width apart and arms at your sides. Jump explosively, spreading your legs out to shoulder-width and raising your arms overhead." +
                                    " Jump back to the starting position and repeat. Focus on landing softly and using your core for stability."
                        )
                        val muscleGroups = listOf(
                            "Quads", "Hamstrings", "Calves", "Shoulders"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Jumping Squats"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "  Squat down as if sitting in a chair, keeping your back straight and knees tracking over your toes. Jump explosively upwards from the squat position," +
                                    " extending your legs fully and reaching your arms overhead. Land softly and immediately lower back down into a squat for the next repetition."
                        )
                        val muscleGroups = listOf(
                            "Quads", "Hamstrings", "Glutes", "Calves", "Core"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Jumping Lunges"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Step forward with one leg, lowering your body down until both knees are bent at 90-degree angles. Ensure your front knee tracks over your ankle and your back knee doesn't touch the ground. Jump explosively upwards," +
                                    " switching legs in mid-air and landing with the other leg forward. Repeat, alternating legs with each jump."
                        )
                        val muscleGroups = listOf(
                            "Quads", "Hamstrings", "Glutes", "Calves", "Core"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Mountain Climbers"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "  Start in a high plank position with your hands shoulder-width apart. Alternate bringing your knees towards your chest in a running motion, keeping your core engaged and back straight." +
                                    " Maintain a quick and rhythmic pace, focusing on core stability and avoiding arching your back."
                        )
                        val muscleGroups = listOf(
                            "Core", "Shoulders", "Hips", "Quads"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Bicycles"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Lie flat on your back with knees bent and feet flat on the floor. Place your fingertips lightly behind your ears, avoiding pulling on your neck. Engage your core and lift your shoulders off the ground, twisting your torso to bring one knee towards your opposite elbow. Simultaneously, " +
                                    "extend the other leg straight out. Alternate sides in a continuous pedaling motion, keeping your lower back pressed into the floor."
                        )
                        val muscleGroups = listOf(
                            "Obliques", "Core", "Hips"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Leg flutters"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Lie flat on your back with legs extended straight and arms at your sides. Keep your core engaged and slowly lift both legs off the ground a few inches." +
                                    " Flutter your legs up and down in a small, controlled motion. Avoid swinging your legs or using momentum."
                        )
                        val muscleGroups = listOf(
                            "Lower Abs"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Russian Twist"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Sit on the floor with knees bent and feet flat on the ground. Lean back slightly, keeping your back straight and core engaged. Twist your torso from side to side," +
                                    " reaching towards the ground with your hands on either side (but not touching). Avoid using momentum and focus on rotating from your core."
                        )
                        val muscleGroups = listOf(
                            "Obliques"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Plank"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Start in a high plank position with your hands shoulder-width apart, directly under your shoulders. Keep your core engaged, back straight, and form a straight line from your head to your heels. " +
                                    "Hold the position for the designated time, focusing on maintaining proper form and breathing deeply."
                        )
                        val muscleGroups = listOf(
                            "Core", "Shoulders", "Glutes", "Hamstrings", "Quads"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListWeightLoss(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

            }
        }
    }
}

@Composable
fun MuscleListWeightLoss(muscleGroups:List<String>) {
    val rows = ceil(muscleGroups.size / 2.0f).toInt() // Calculate number of rows

    Column {
        for (row in 0 until rows) {
            Row {
                val firstIndex = row * 2
                val secondIndex = (row * 2) + 1

                if (firstIndex < muscleGroups.size) {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp) // Add padding
                            .weight(1f), // Fill available space in the row
                        color = Color.LightGray // Set background color
                    ) {
                        Text(
                            text = "• ${muscleGroups[firstIndex]}", // Add bullet symbol and space
                            style = TextStyle(color = Color.Black) // Optional style for bullet
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f)) // Add space between muscles

                if (secondIndex < muscleGroups.size) {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp) // Add padding
                            .weight(1f), // Fill available space in the row
                        color = Color.LightGray // Set background color
                    ) {
                        Text(
                            text = "• ${muscleGroups[secondIndex]}",
                            style = TextStyle(color = Color.Black) // Optional style for bullet
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LoadImageWeightLoss(storage:Int,size: Dp?){
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(storage, imageLoader),
        contentDescription = null,
        modifier = Modifier.size(size ?: Dp.Unspecified)
    )

}
val workoutItemsWeightLoss = listOf(
    // Replace with your actual data for texts and storage references
    WorkoutItem("But Kicks", R.drawable.butkicks,"45s"),
    WorkoutItem("Burpees", R.drawable.burpees,"45s"),
    WorkoutItem("Jumping Jacks", R.drawable.jumpingjacks,"45s"),
    WorkoutItem("Jumping Squats", R.drawable.jumpingsquats,"45s"),
    WorkoutItem("Jumping Lunges", R.drawable.jumpinglunges,"45s"),
    WorkoutItem("Mountain Climbers", R.drawable.mountainclimber,"45s"),
    WorkoutItem("Bicycles", R.drawable.bicycles,"45s"),
    WorkoutItem("Leg flutters", R.drawable.legflutters,"45s"),
    WorkoutItem("Russian Twist", R.drawable.russiantwist,"45s"),
    WorkoutItem("Plank", R.drawable.plank,"45s")
)
@Composable
fun WorkoutListWeightLoss() {
    //val scrollState = rememberScrollState()
    var showSheet by remember { mutableStateOf(false) }
    var selectedWorkout by remember { mutableStateOf<WorkoutItem?>(null) }

    if (showSheet) {
        BottomSheetWeightLoss(selectedWorkout) {
            showSheet = false
        }
    }

    LazyColumn (contentPadding = PaddingValues(bottom = 56.dp)){
        items(workoutItemsWeightLoss.size) { item ->
            val item = workoutItemsWeightLoss[item]
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clickable { showSheet = true;selectedWorkout = item }) {
                LoadImageWeightLoss(item.imageStorageReference, 150.dp)
                Column(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterVertically)) {
                    Text(text = item.name)
                    Text(text = item.time)
                }
            }
            HorizontalDivider()
        }
    }
}
data class WorkoutItemWeightLoss(val name: String, val imageStorageReference: Int,val time:String)