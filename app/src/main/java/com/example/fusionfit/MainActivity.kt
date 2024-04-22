package com.example.fusionfit

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fusionfit.ui.theme.FusionFitTheme
import com.example.fusionfit.ui.theme.appbgcolor
import com.example.fusionfit.ui.theme.headerColor
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf as mutableStateOf1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen() 
        setContent {
            FusionFitTheme {
                // A surface container using the 'background' color from the theme
                Surface (
                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
                    color = Color.White
                ) {
                    navDrawerTopAppBarBottomNav()
//                    learnBottomNavbar()
//                    LearnNavigationDrawer()
//                    learnTopAppBar()
//                    learnState()
//                    learnImage()
//                    learnButton()
//                    Alignment_Arrangement()
//                    textAndModifiers()
                } // Box body ends
            }
        }
    }
}










@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun navDrawerTopAppBarBottomNav(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val imageIds = listOf(
        R.drawable.card1,
        R.drawable.card2,
        R.drawable.card3,
        R.drawable.card4,
        R.drawable.card5,
        R.drawable.card7,
        R.drawable.card6
    )

    val imageIdsForWorkout = listOf(

        R.drawable.card3,
        R.drawable.card4,
        R.drawable.card6
    )


    val imageIdsForDiet = listOf(

        R.drawable.card1,
        R.drawable.card2,
        R.drawable.card5,
        R.drawable.card7
    )



    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
                Box(modifier = Modifier
                    .background(appbgcolor)
                    .fillMaxWidth()
                    .height(150.dp)){
                    Text(text = "FusionFit", modifier = Modifier.align(Alignment.Center))
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = headerColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home", tint = headerColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        selected.value=Icons.Default.Home
                        navigationController.navigate(Screens.Home.screens){
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = headerColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "profile", tint = headerColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        selected.value=Icons.Default.Person
                        navigationController.navigate(Screens.Profile.screens){
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = headerColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "setting", tint = headerColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        selected.value=Icons.Default.Settings
                        navigationController.navigate(Screens.Settings .screens){
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Logout", color = headerColor) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "logout", tint = headerColor) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context,"Logged Out",Toast.LENGTH_SHORT).show()
                    })
            }
        }
    ) {
        Scaffold(
            topBar = {

                TopAppBar(title = { Text(text = "FusionFit")},
                    navigationIcon = {
                        IconButton(onClick = {coroutineScope.launch{drawerState.open()}}) {
//                Icon(painter = painterResource(id = R.drawable.gymlogo), contentDescription ="Logo" )
                            Icon(
                                Icons.Rounded.Menu,contentDescription = "MenuButton"
                            )
                        }
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = headerColor,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ), actions = {
                        IconButton(onClick = { Toast.makeText(context,"Profile",Toast.LENGTH_SHORT).show()})
                        {
                            Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
                        }
                        IconButton(onClick = { Toast.makeText(context,"Search",Toast.LENGTH_SHORT).show()})
                        {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                        }
                        IconButton(onClick = { Toast.makeText(context,"Menu",Toast.LENGTH_SHORT).show()})
                        {
                            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White)
                        }
                    })
            },
            bottomBar = {
                BottomAppBar(containerColor = headerColor) {
                    IconButton(
                        onClick = {
                            selected.value=Icons.Default.Home
                            navigationController.navigate(Screens.Home.screens){
                                popUpTo(0)
                            }
                        }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Home, contentDescription ="home",modifier=Modifier.size(26.dp), tint =  if (selected.value == Icons.Default.Home) Color.White else  Color.DarkGray )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Search
                            navigationController.navigate(Screens.Workout.screens) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.muscleicon3),
                            contentDescription = "search",
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                        )
                    }


//                    Box(modifier = Modifier
//                        .weight(1f)
//                        .padding(16.dp), contentAlignment = Alignment.Center) {
//                        FloatingActionButton(onClick = { Toast.makeText(context,"Opened Bottom Sheet",Toast.LENGTH_SHORT).show() }) {
//                            Icon(Icons.Default.Add, contentDescription = "add", tint = headerColor)
//                        }
//                    }

                    IconButton(
                        onClick = {
                            selected.value=Icons.Default.Notifications
                            navigationController.navigate(Screens.Diet.screens){
                                popUpTo(0)
                            }
                        }, modifier = Modifier.weight(1f)) {
                        Icon(painterResource(id = R.drawable.diet3),
                            contentDescription ="diet",
                            modifier=Modifier.size(26.dp),
                            tint =  if (selected.value == Icons.Default.Notifications) Color.White else  Color.DarkGray )
                    }

                    IconButton(
                        onClick = {
                            selected.value=Icons.Default.ExitToApp
                            navigationController.navigate(Screens.Customized.screens){
                                popUpTo(0)
                            }
                        }, modifier = Modifier.weight(1f)) {
                        Icon(
                            painterResource(id = R.drawable.customicon),
                            contentDescription ="profile",modifier=Modifier.size(26.dp), 
                            tint =  if (selected.value == Icons.Default.ExitToApp) Color.White else  Color.DarkGray )
                    }


                }
            }
        ) {
            NavHost(navController = navigationController,
                startDestination = Screens.Home.screens  ){
                composable(Screens.Home.screens){ Home(navController = navigationController,quotes = listOf("The only bad workout is the one that didn't happen", "Success isn't given. It's earned. On the track, on the field, in the gym. With blood, sweat, and the occasional tear", "The pain you feel today will be the strength you feel tomorrow", "The only way to define your limits is by going beyond them"),images=imageIds)}
                composable(Screens.Profile.screens){ Profile() }
                composable(Screens.Workout.screens){ Workout(navController = navigationController, images = imageIdsForWorkout) }
                composable(Screens.Diet.screens){ Diet(navController = navigationController, images = imageIdsForDiet) }
                composable(Screens.Settings.screens){ Settings() }
                composable(Screens.MuscleBuildingExercises.screens){ MuscleBuildingExercises()}
                composable(Screens.Cardio.screens){ Cardio()}
                composable(Screens.MuscleGainNonVeg.screens){ MuscleGainNonVeg()}
                composable(Screens.MuscleGainVeg.screens){ MuscleGainVeg()}
                composable(Screens.WeightLossExercises.screens){ WeightLossExercises()}
                composable(Screens.WeightLossNonVeg.screens){ WeightLossNonVeg()}
                composable(Screens.WeightLossVeg.screens){ WeightLossVeg()}
                composable(Screens.MuscleBuildingExercises.screens){ MuscleBuildingExercises()}
                composable(Screens.Customized.screens){ Customized(navController=navigationController)}
                composable(Screens.GainMuscleCustomized.screens){ GainMuscleCustomized() }
                composable(Screens.LoseMuscleCustomized.screens){ LoseMuscleCustomized() }
            }
        }
    }
}






@Composable
@Preview
fun ShowPreviewMainApp(){
    FusionFitTheme {
        navDrawerTopAppBarBottomNav()
    }
}






//@Composable
//fun learnBottomNavbar(){
//    val navigationController = rememberNavController()
//    val context = LocalContext.current.applicationContext
//    val selected = remember {
//        mutableStateOf(Icons.Default.Home)
//    }
//
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(containerColor = headerColor) {
//                IconButton(
//                    onClick = {
//                        selected.value=Icons.Default.Home
//                        navigationController.navigate(Screens.Home.screens){
//                            popUpTo(0)
//                        }
//                    }, modifier = Modifier.weight(1f)) {
//                    Icon(Icons.Default.Home, contentDescription ="home",modifier=Modifier.size(26.dp), tint =  if (selected.value == Icons.Default.Home) Color.White else  Color.DarkGray )
//                }
//                IconButton(
//                    onClick = {
//                        selected.value=Icons.Default.Search
//                        navigationController.navigate(Screens.Search.screens){
//                            popUpTo(0)
//                        }
//                    }, modifier = Modifier.weight(1f)) {
//                    Icon(Icons.Default.Search, contentDescription ="search",modifier=Modifier.size(26.dp), tint =  if (selected.value == Icons.Default.Search) Color.White else  Color.DarkGray )
//                }
//
//                Box(modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp), contentAlignment = Alignment.Center) {
//                    FloatingActionButton(onClick = { Toast.makeText(context,"Opened Bottom Sheet",Toast.LENGTH_SHORT).show() }) {
//                        Icon(Icons.Default.Add, contentDescription = "add", tint = headerColor)
//                    }
//                }
//
//                IconButton(
//                    onClick = {
//                        selected.value=Icons.Default.Notifications
//                        navigationController.navigate(Screens.Notificaition.screens){
//                            popUpTo(0)
//                        }
//                    }, modifier = Modifier.weight(1f)) {
//                    Icon(Icons.Default.Notifications, contentDescription ="notification",modifier=Modifier.size(26.dp), tint =  if (selected.value == Icons.Default.Notifications) Color.White else  Color.DarkGray )
//                }
//
//                IconButton(
//                    onClick = {
//                        selected.value=Icons.Default.Person
//                        navigationController.navigate(Screens.Profile.screens){
//                            popUpTo(0)
//                        }
//                    }, modifier = Modifier.weight(1f)) {
//                    Icon(Icons.Default.Person, contentDescription ="profile",modifier=Modifier.size(26.dp), tint =  if (selected.value == Icons.Default.Person) Color.White else  Color.DarkGray )
//                }
//
//
//            }
//        }
//    ) {paddingValues ->
//        NavHost(
//            navController = navigationController,
//            startDestination = Screens.Home.screens,
//            modifier = Modifier.padding(paddingValues)){
//            composable(Screens.Home .screens){ Home()}
//            composable(Screens.Notificaition .screens){ Notification()}
//            composable(Screens.Profile .screens){ Profile() }
//            composable(Screens.Search  .screens){ Search() }
//
//        }
//    }
//
//}







//fun LearnNavigationDrawer(){
//    val navigationController = rememberNavController()
//    val coroutineScope = rememberCoroutineScope()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val context = LocalContext.current.applicationContext
//
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        gesturesEnabled = true,
//        drawerContent = {
//            ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
//                Box(modifier = Modifier
//                    .background(appbgcolor)
//                    .fillMaxWidth()
//                    .height(150.dp)){
//                    Text(text = "FusionFit", modifier = Modifier.align(Alignment.Center))
//                }
//                Divider()
//                NavigationDrawerItem(
//                    label = { Text(text = "Home", color = headerColor) },
//                    selected = false,
//                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home", tint = headerColor) },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        navigationController.navigate(Screens.Home.screens){
//                            popUpTo(0)
//                        }
//                    })
//
//                NavigationDrawerItem(
//                    label = { Text(text = "Profile", color = headerColor) },
//                    selected = false,
//                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "profile", tint = headerColor) },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        navigationController.navigate(Screens.Profile.screens){
//                            popUpTo(0)
//                        }
//                    })
//
//                NavigationDrawerItem(
//                    label = { Text(text = "Settings", color = headerColor) },
//                    selected = false,
//                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "setting", tint = headerColor) },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        navigationController.navigate(Screens.Settings .screens){
//                            popUpTo(0)
//                        }
//                    })
//
//                NavigationDrawerItem(
//                    label = { Text(text = "Logout", color = headerColor) },
//                    selected = false,
//                    icon = { Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "logout", tint = headerColor) },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        Toast.makeText(context,"Logged Out",Toast.LENGTH_SHORT).show()
//                    })
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//
//                TopAppBar(title = { Text(text = "FusionFit")},
//                    navigationIcon = {
//                        IconButton(onClick = {coroutineScope.launch{drawerState.open()}}) {
////                Icon(painter = painterResource(id = R.drawable.gymlogo), contentDescription ="Logo" )
//                            Icon(
//                                Icons.Rounded.Menu,contentDescription = "MenuButton"
//                            )
//                        }
//                    }, colors = TopAppBarDefaults.topAppBarColors(
//                        containerColor = headerColor,
//                        titleContentColor = Color.White,
//                        navigationIconContentColor = Color.White
//                    ), actions = {
//                        IconButton(onClick = { Toast.makeText(context,"Profile",Toast.LENGTH_SHORT).show()})
//                        {
//                            Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
//                        }
//                        IconButton(onClick = { Toast.makeText(context,"Search",Toast.LENGTH_SHORT).show()})
//                        {
//                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
//                        }
//                        IconButton(onClick = { Toast.makeText(context,"Menu",Toast.LENGTH_SHORT).show()})
//                        {
//                            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White)
//                        }
//                    })
//            }
//        ) {
//            NavHost(navController = navigationController,
//                startDestination = Screens.Home.screens  ){
//                composable(Screens.Home.screens){ Home()}
//                composable(Screens.Profile.screens){ Profile() }
//                composable(Screens.Settings.screens){ Settings() }
//            }
//        }
//    }
//}
//
//











//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun learnTopAppBar(){
//    var context = LocalContext.current.applicationContext
//    TopAppBar(title = { Text(text = "FusionFit")},
//        navigationIcon = {
//            IconButton(onClick = {coroutineScope.launch{drawerState.open()}}) {
////                Icon(painter = painterResource(id = R.drawable.gymlogo), contentDescription ="Logo" )
//                  Icon(
//                        Icons.Rounded.Menu,contentDescription = "MenuButton"
//                  )
//            }
//        }, colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = headerColor,
//            titleContentColor = Color.White,
//            navigationIconContentColor = Color.White
//        ), actions = {
//            IconButton(onClick = { Toast.makeText(context,"Profile",Toast.LENGTH_SHORT).show()})
//            {
//                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
//            }
//            IconButton(onClick = { Toast.makeText(context,"Search",Toast.LENGTH_SHORT).show()})
//            {
//                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
//            }
//            IconButton(onClick = { Toast.makeText(context,"Menu",Toast.LENGTH_SHORT).show()})
//            {
//                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White)
//            }
//        })
//}

//@Preview
//@Composable
//fun showPreview(){
//    FusionFitTheme {
//        learnTopAppBar()
//    }
//}
















//@Composable
//fun learnState(){
//    //var age = 0
//    var age by remember {
//        mutableStateOf1(0)
//    }
//
//    Column {
//        Button(onClick = {age++ }) {
//            Text(text = "Age is $age")
//        }
//    }
//}

//@Composable
//fun learnImage(){
//    Image(painter = painterResource(id = R.drawable.gymlogo), contentDescription ="Logo" )
//}













//@Composable
//fun learnButton(){
//    val context = LocalContext.current.applicationContext
//    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//        Button(onClick = { Toast.makeText(context,"login Successfull",Toast.LENGTH_SHORT).show()},
//            shape = RoundedCornerShape(size = 16.dp), colors = ButtonDefaults .buttonColors(containerColor = Color.Blue )) {
//            Text(text = "Login")
//        }
//    }
//}















//@Composable
//fun Alignment_Arrangement()
//{
//     Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center)
//     {
//         Text(text = "Row Alignment Araangement ")
//     }
//
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
//    {
//        Text(text = "Column Alignment Arrangement")
//    }
//
//
//    Box(contentAlignment = Alignment.BottomCenter)
//    {
//        Text(text = "Box Alignment only....arrangement doesn't exists")
////        Text(text = "Box Alignment only....arrangement doesn't exists", modifier = Modifier.align(Alignment.Center))
//    }
//}















//@Composable
//fun textAndModifiers(){
////    Text(text = "Hello World ",
////        color = Color.Red,
////        fontSize = 32.sp,
////        fontStyle = FontStyle.Italic
////    )
//
//    val clickOnText = {}
//    Text(text = stringResource(id = R.string.custom_string),
//        modifier = Modifier
//            .background(Color.Black)
//            .padding(22.dp)
//            .clickable(onClick = clickOnText),
//        color = Color.Blue,
//        fontStyle = FontStyle.Italic,
//        fontSize = 32.sp
//    )
//}
//
//


//@Preview(showBackground = true)
//@Composable
//fun showPreview(){
//    FusionFitTheme{
//        textAndModifiers()
//    }
//}