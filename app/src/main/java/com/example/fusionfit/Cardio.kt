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
fun Cardio (){
    Box (modifier = Modifier.padding(top = 20.dp)){
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.stretching_card),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(text = "10 mins-10 workouts(Hold Position of Each Exercise for 30s)", modifier = Modifier.padding(5.dp),fontSize = 17.sp,fontWeight = FontWeight.Bold)
            HorizontalDivider()
            WorkoutListStretching()
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetStretching(selectedWorkout:WorkoutItemStretching?,onDismiss: () -> Unit) {
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
                    LoadImageStretching(selectedWorkout.imageStorageReference, 300.dp)
                }
                Row (modifier=Modifier.padding(10.dp)) {
                    Text("DURATION",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text("${selectedWorkout.time}")
                }
                if (selectedWorkout.name == "Neck stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sit or stand tall and slowly tilt your head to one side, bringing your ear towards your shoulder. You can also use your hand to gently guide your head further." +
                                    " Hold and feel the stretch along the side of your neck. Repeat on the other side."
                        )
                        val muscleGroupsStretching = listOf(
                            "Neck"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Triceps Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall with one arm raised overhead. Bend your elbow behind your head and use your other hand to gently push your elbow down towards your tricep." +
                                    " Feel the stretch along the back of your upper arm. Hold, then repeat with the other arm."
                        )
                        val muscleGroupsStretching = listOf(
                            "Triceps"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Bicep Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall with one arm extended behind your back. Use your other hand to gently pull your elbow upwards towards your shoulder." +
                                    " Feel the stretch in the front of your upper arm. Hold, then repeat with the other arm."
                        )
                        val muscleGroupsStretching = listOf(
                            "Biceps"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Chest Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall with your feet shoulder-width apart. Clasp your hands behind your back and gently push your chest forward, " +
                                    "opening up your shoulders and squeezing your shoulder blades together. Hold and feel the stretch across your chest and shoulders."
                        )
                        val muscleGroupsStretching = listOf(
                            "Chest", "Shoulders"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Quad Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall and hold one foot behind your calf, grasping your toes or ankle. Gently pull your heel towards your glutes, squeezing your buttocks." +
                                    " You should feel a stretch in the front of your thigh. Hold, then repeat with the other leg."
                        )
                        val muscleGroupsStretching = listOf(
                            "Quads"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Calf Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand with your hands on a wall or other support in front of you. Step one leg back with your heel flat on the ground and your front leg straight." +
                                    " Lean forward, keeping your front heel down, until you feel a stretch in your calf. Hold, then repeat with the other leg."
                        )
                        val muscleGroupsStretching = listOf(
                            "Calves"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Cobra Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Lie on your stomach with your palms flat on the floor beside your shoulders, elbows tucked in close to your body. Gently press your upper body up off the ground, arching your back slightly and keeping your hips on the floor. Focus on opening your chest and keeping your shoulders relaxed." +
                                    "Don't force the stretch and maintain a comfortable position where you can breathe deeply."
                        )
                        val muscleGroupsStretching = listOf(
                            "Spine", "Shoulders"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Child's Pose"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Kneel on the floor with your toes together and sit back on your heels. Separate your knees slightly wider than your hips and rest your forehead on the floor in front of you," +
                                    " arms extended out in front with palms facing down. Breathe deeply and allow your body to relax completely."
                        )
                        val muscleGroupsStretching = listOf(
                            "Spine",
                            "Glutes",
                            "Thighs",
                            "Ankles"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Catcow stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Start on all fours with hands shoulder-width apart and knees hip-width apart. Inhale and arch your back, looking up and dropping your belly down. Exhale, round your back, tucking your chin and sinking your belly further." +
                                    " Breathe deeply and repeat this cat-like arch and cow-like rounding motion for several repetitions."
                        )
                        val muscleGroupsStretching = listOf(
                            "Spine", "Core", "Hips"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Hamstring Stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sit on the floor with one leg extended straight in front of you. The other leg should be bent with the foot flat on the floor beside you. Lean forward from your hips, reaching towards your extended foot and keeping your back straight. Avoid rounding your shoulders." +
                                    "Feel the stretch in the back of your extended leg and hold for the designated time. Repeat with the other leg."
                        )
                        val muscleGroupsStretching = listOf(
                            "Hamstrings"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color= Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleListStretching(muscleGroupsStretching)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

            }
        }
    }
}

@Composable
fun MuscleListStretching(muscleGroupsStretching:List<String>) {
    val rows = ceil(muscleGroupsStretching.size / 2.0f).toInt() // Calculate number of rows

    Column {
        for (row in 0 until rows) {
            Row {
                val firstIndex = row * 2
                val secondIndex = (row * 2) + 1

                if (firstIndex < muscleGroupsStretching.size) {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp) // Add padding
                            .weight(1f), // Fill available space in the row
                        color = Color.LightGray // Set background color
                    ) {
                        Text(
                            text = "• ${muscleGroupsStretching[firstIndex]}", // Add bullet symbol and space
                            style = TextStyle(color = Color.Black) // Optional style for bullet
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f)) // Add space between muscles

                if (secondIndex < muscleGroupsStretching.size) {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp) // Add padding
                            .weight(1f), // Fill available space in the row
                        color = Color.LightGray // Set background color
                    ) {
                        Text(
                            text = "• ${muscleGroupsStretching[secondIndex]}",
                            style = TextStyle(color = Color.Black) // Optional style for bullet
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LoadImageStretching(storage:Int,size: Dp?){
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
val workoutItemsStretching = listOf(
    // Replace with your actual data for texts and storage references
    WorkoutItemStretching("Neck stretch", R.drawable.neckstretch,"30s hold"),
    WorkoutItemStretching("Triceps Stretch", R.drawable.tricepsstretch,"30s hold"),
    WorkoutItemStretching("Bicep Stretch", R.drawable.bicepstretch,"30s hold"),
    WorkoutItemStretching("Chest Stretch", R.drawable.cheststretch,"30s hold"),
    WorkoutItemStretching("Quad Stretch", R.drawable.quadstretch,"30s hold"),
    WorkoutItemStretching("Calf Stretch", R.drawable.calfstretch,"30s hold"),
    WorkoutItemStretching("Cobra Stretch", R.drawable.cobrastretch,"30s hold"),
    WorkoutItemStretching("Child's Pose", R.drawable.childpose,"30s hold"),
    WorkoutItemStretching("Catcow Stretch", R.drawable.backstretch,"30s hold"),
    WorkoutItemStretching("Hamstring Stretch", R.drawable.hamstringstretch,"30s hold")
)
@Composable
fun WorkoutListStretching() {
    //val scrollState = rememberScrollState()
    var showSheet by remember { mutableStateOf(false) }
    var selectedWorkout by remember { mutableStateOf<WorkoutItemStretching?>(null) }

    if (showSheet) {
        BottomSheetStretching(selectedWorkout) {
            showSheet = false
        }
    }

    LazyColumn (contentPadding = PaddingValues(bottom = 56.dp)){
        items(workoutItemsStretching.size) { item ->
            val item = workoutItemsStretching[item]
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(140.dp)
                .clickable { showSheet = true;selectedWorkout = item }) {
                LoadImageStretching(item.imageStorageReference, 150.dp)
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
data class WorkoutItemStretching(val name: String, val imageStorageReference: Int,val time:String)