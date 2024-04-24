package com.example.fusionfit

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){
    data object SignUpScreen : Screen()
    data object LoginScreen : Screen()
    data object Sample : Screen()
//    object MainHomeScreen : Screen()

}
object LoginRouter{
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)
    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }
}