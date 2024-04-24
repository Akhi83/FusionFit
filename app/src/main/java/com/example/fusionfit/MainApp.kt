package com.example.fusionfit


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun MainApp(){

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

        Crossfade(targetState = LoginRouter.currentScreen) { currentState->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.LoginScreen ->{
                    LoginScreen()
                }
                is Screen.Sample ->{
                    Sample()
                }

            }

        }


    }
}
