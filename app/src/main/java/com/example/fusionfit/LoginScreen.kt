package com.example.fusionfit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fusionfit.data.LoginUIEvent
import com.example.fusionfit.data.LoginViewModel
import com.example.fusionfit.data.SignUpViewModel
import com.example.fusionfit.data.SignupUIEvent

@Composable
fun LoginScreen(loginViewModel: LoginViewModel= viewModel()){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(90.dp))

                NormalTextComponent(value = "Login")

                HeadingTextComponent(value = "Welcome Back")

                Spacer(modifier = Modifier.height(90.dp))

                MyTextField(
                    labelValue = "Email",
                    painterResource = painterResource(id = R.drawable.message),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))

                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextField(
                    labelValue = "Password",
                    painterResource = painterResource(id = R.drawable.ic_lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))

                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(90.dp))

                ButtonComponent(
                    value = "Login",
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationPassed.value
                )

                Spacer(modifier = Modifier.height(30.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    LoginRouter.navigateTo(Screen.SignUpScreen)

                })

            }


        }
        if (loginViewModel.logInProgress.value){
            CircularProgressIndicator()

        }

    }
    SystemBackButtonHandler {
        LoginRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}