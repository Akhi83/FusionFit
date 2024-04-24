package com.example.fusionfit

import androidx.compose.runtime.Composable
import com.example.fusionfit.data.SignUpViewModel

@Composable
fun Sample(){
    navDrawerTopAppBarBottomNav(signUpViewModel = SignUpViewModel())

}