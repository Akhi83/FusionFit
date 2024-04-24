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
import com.example.fusionfit.data.SignUpViewModel
import com.example.fusionfit.data.SignupUIEvent


@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()){

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                NormalTextComponent(value = "Hey there,")

                HeadingTextComponent(value = "Create an Account")

                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(labelValue = "First Name",
                    painterResource = painterResource(id = R.drawable.profile),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.firstNameError)

                MyTextField(labelValue = "Last Name",
                    painterResource = painterResource(id = R.drawable.profile),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.lastNameError)

                MyTextField(labelValue = "Email",
                    painterResource = painterResource(id = R.drawable.message),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignupUIEvent.EmailChanged(it))

                    },
                    errorStatus = signUpViewModel.registrationUIState.value.emailError)

                PasswordTextField(labelValue = "Password",
                    painterResource = painterResource(id = R.drawable.ic_lock),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignupUIEvent.PasswordChanged(it))

                    },
                    errorStatus = signUpViewModel.registrationUIState.value.passwordError)

                Spacer(modifier = Modifier.height(120.dp))

                ButtonComponent(value = "Register",
                    onButtonClicked = {
                        signUpViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signUpViewModel.allValidationPassed.value)

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true,onTextSelected = {
                    LoginRouter.navigateTo(Screen.LoginScreen)
                })
            }

        }
        if(signUpViewModel.signUpInProgress.value){
            CircularProgressIndicator()

        }

    }


}


@Preview
@Composable
fun DefaultPreviewOfSignUPScreen(){
    SignUpScreen()
}
