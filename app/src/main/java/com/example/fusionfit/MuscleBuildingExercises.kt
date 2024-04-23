package com.example.fusionfit

import android.os.Build.VERSION.SDK_INT
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
fun MuscleBuildingExercises (){
    Box {
        Column(modifier = Modifier.padding(top = 42.dp)

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)

            ) {
                            Image(
                                painter = painterResource(id = R.drawable.card6),
//                                painter = painterResource(id = R.drawable.musclebuilding),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
            }

            Text(text = "30 mins-13 workouts", modifier = Modifier.padding(5.dp),fontSize = 17.sp,fontWeight = FontWeight.Bold)
            HorizontalDivider()
            WorkoutList()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(selectedWorkout:WorkoutItem?,onDismiss: () -> Unit) {
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
                    LoadImage(storage = selectedWorkout.imageStorageReference, size=300.dp )
                }
                Row (modifier=Modifier.padding(10.dp)) {
                    Text("DURATION",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text("${selectedWorkout.time}")
                }
                if (selectedWorkout.name == "Jumping jacks"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Start by standing tall with your feet shoulder-width apart and arms at your sides. " +
                                    "Jump explosively, spreading your legs wider than shoulder-width and raising your arms overhead. " +
                                    "Briefly clap your hands together if desired. Then, jump back down, returning to the starting position." +
                                    " Maintain a slight knee bend throughout and focus on a steady breathing rhythm. Repeat for your desired duration or repetitions, " +
                                    "keeping your core engaged for stability and landing softly on the balls of your feet. "
                        )
                        val muscleGroups = listOf(
                            "Quadriceps", "Hamstrings",
                            "Calves", "Glutes",
                            "Shoulders", "Core"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "High Knees"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall with feet shoulder-width apart. Bring knees up high towards your chest while pumping your arms. Start with short durations and gradually increase intensity as you get fitter. Focus on driving knees up with power and maintain good form" +
                                    ". Breathe deeply and listen to your body throughout. " +
                                    "Modify the exercise by lowering knee lift height or add a jump for more challenge. "
                        )
                        val muscleGroups = listOf(
                            "Quadriceps",
                            "Hamstrings",
                            "Calves",
                            "Glutes",
                            "Hip Flexors",
                            "Core",
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Knee pushups"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Start in a high kneeling position with hands shoulder-width apart, directly under your shoulders. Keep your back straight and core engaged. Lower your chest towards the ground by bending your elbows, then press back up to starting position. Focus on a controlled movement and breathe deeply. Modify by placing your knees closer together for a more challenging variation" +
                                    ". Aim for sets of manageable repetitions with good form, gradually increasing difficulty as you get stronger."
                        )
                        val muscleGroups = listOf(
                            "Chest",
                            "Triceps",
                            "Shoulders",
                            "Core"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Tricep dips"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Find a sturdy bench or surface slightly above knee height. Sit with your back towards the edge and hands shoulder-width apart, gripping the surface with your fingers pointing forward. Extend your legs straight out in front or bend them with your feet flat for stability. Engage your core and slowly lower yourself by bending your elbows until your upper arms are parallel to the floor. Keep your back close to the bench and avoid arching it. " +
                                    "Push back up to the starting position using your triceps, maintaining control throughout the movement."
                        )
                        val muscleGroups = listOf(
                            "Triceps", "Shoulders"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Australian Pullups"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Locate a sturdy bar or low surface below knee height. Lie flat on your back with arms extended overhead, grasping the bar with a wide grip (wider than shoulder-width). Engage your core and back muscles to pull yourself upwards, bringing your chest as close to the bar as possible. Focus on squeezing your shoulder blades together at the top. " +
                                    "Slowly lower yourself back down to the starting position in a controlled manner."
                        )
                        val muscleGroups = listOf(
                            "Back (Lats, Upper Back)", "Biceps"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Squats"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Stand tall with your feet shoulder-width apart, toes slightly pointed outwards. Engage your core and keep your back straight throughout the movement. Pretend you're about to sit in a chair, and lower your body down by bending your knees and hips. Push your hips back slightly and ensure your knees track over your toes (don't let them cave inwards). Descend until your thighs are roughly parallel to the floor. " +
                                    "Push back up to the starting position using your glutes and quads, maintaining proper form."
                        )
                        val muscleGroups = listOf(
                            "Quads", "Hamstrings", "Glutes", "Core"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Lunges"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Stand tall with your feet hip-width apart. Step forward with one leg, lowering your body down until both knees are bent at 90-degree angles. Ensure your front knee tracks over your ankle and your back knee doesn't touch the ground. Keep your core engaged and back straight throughout the movement." +
                                    " Push back up to the starting position using your front leg, then repeat with the other leg."
                        )
                        val muscleGroups = listOf(
                            "Quads", "Hamstrings", "Glutes", "Core"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Crunches"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Lie flat on your back with knees bent and feet flat on the floor. Place your fingertips lightly behind your ears, avoiding pulling on your neck. Engage your core muscles and lift your upper body off the ground, initiating the movement from your abs and not your neck. Curl your upper body towards your knees, keeping your lower back pressed into the floor." +
                                    " Slowly lower yourself back down in a controlled manner, without completely relaxing your core muscles."
                        )
                        val muscleGroups = listOf(
                            "Abs"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Mountain climbers"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Start in a high plank position with your hands shoulder-width apart, directly under your shoulders. Keep your core engaged and back straight, forming a straight line from your head to your heels. Alternate bringing your knees towards your chest in a running motion, keeping your feet light and off the ground." +
                                    " Maintain a quick and rhythmic pace while focusing on core stability and avoiding arching your back."
                        )
                        val muscleGroups = listOf(
                            "Core", "Shoulders", "Hips", "Quads"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Leg raises"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Lie flat on your back with legs extended straight and arms at your sides, palms facing down. Engage your core and slowly lift your legs together until they are perpendicular to the floor. Avoid using momentum and focus on contracting your lower abs to raise your legs. Keep your back pressed into the ground and avoid arching it." +
                                    " Slowly lower your legs back down to the starting position in a controlled manner, without completely relaxing your abs."
                        )
                        val muscleGroups = listOf(
                            "Lower Abs"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Cobra stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Lie on your stomach with your palms flat on the floor beside your shoulders, elbows tucked in close to your body. Gently press your upper body up off the ground, arching your back slightly and keeping your hips on the floor. Focus on opening your chest and keeping your shoulders relaxed." +
                                    " Don't force the stretch and maintain a comfortable position where you can breathe deeply."
                        )
                        val muscleGroups = listOf(
                            "Spine", "Shoulders"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Child pose"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " Kneel on the floor with your toes together and sit back on your heels. Separate your knees slightly wider than your hips and rest your forehead on the floor in front of you," +
                                    " arms extended out in front with palms facing down. Breathe deeply and allow your body to relax completely."
                        )
                        val muscleGroups = listOf(
                            "Spine",
                            "Glutes",
                            "Thighs",
                            "Ankles"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (selectedWorkout.name == "Hamstring stretch"){
                    Column(modifier=Modifier.padding(10.dp)) {
                        Text(text = "INSTRUCTIONS",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sit on the floor with one leg extended straight in front of you. The other leg should be bent with the foot flat on the floor beside you. Lean forward from your hips, reaching towards your extended foot and keeping your back straight. Avoid rounding your shoulders." +
                                    " Feel the stretch in the back of your extended leg and hold for the designated time. Repeat with the other leg."
                        )
                        val muscleGroups = listOf(
                            "Hamstrings"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "FOCUS AREA",color=Color.LightGray, fontSize = 20.sp,fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        MuscleList(muscleGroups)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }


            }
        }
    }
}

@Composable
fun MuscleList(muscleGroups:List<String>) {
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
fun LoadImage(storage:Int,size: Dp?){
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
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
val workoutItems = listOf(
    WorkoutItem("Jumping jacks",R.drawable.jumpingjacks ,"20s"),
    WorkoutItem("High Knees", R.drawable.highknees,"20s"),
    WorkoutItem("Knee pushups",R.drawable.kneepushups ,"10X"),
    WorkoutItem("Tricep dips",R.drawable.tricepdips ,"10X"),
    WorkoutItem("Australian Pullups",R.drawable.australianpullups ,"10X"),
    WorkoutItem("Squats",R.drawable.squats ,"10X"),
    WorkoutItem("Lunges", R.drawable.lunges,"10X"),
    WorkoutItem("Crunches", R.drawable.crunches,"15X"),
    WorkoutItem("Mountain climbers", R.drawable.mountainclimbers,"15X"),
    WorkoutItem("Leg raises", R.drawable.legraises,"10X"),
    WorkoutItem("Cobra stretch",R.drawable.cobrastretch ,"10s"),
    WorkoutItem("Child pose", R.drawable.childpose,"10s"),
    WorkoutItem("Hamstring stretch",R.drawable.hamstringstretch,"10s"),
)
@Composable
fun WorkoutList() {
    //val scrollState = rememberScrollState()
    var showSheet by remember { mutableStateOf(false) }
    var selectedWorkout by remember { mutableStateOf<WorkoutItem?>(null) }

    if (showSheet) {
        BottomSheet(selectedWorkout) {
            showSheet = false
        }
    }

    LazyColumn(contentPadding = PaddingValues(bottom = 56.dp)) {
        items(workoutItems.size) { item ->
            val item = workoutItems[item]
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clickable { showSheet = true;selectedWorkout = item }) {
                LoadImage(item.imageStorageReference, 150.dp)
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
data class WorkoutItem(val name: String, val imageStorageReference: Int,val time:String)



