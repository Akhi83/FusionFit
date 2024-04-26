package com.example.fusionfit.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fusionfit.LoginRouter
import com.example.fusionfit.Screen
import com.example.fusionfit.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel(){


    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationPassed = mutableStateOf(false)

    var logInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent){

        validateLoginUIDataWithRules()


        when(event){
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )

            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )


            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()

            }
        }

    }

    private fun login(){
        checkUserInFirebase(
            email =loginUIState.value.email ,
            password = loginUIState.value.password
        )
    }

    private fun validateLoginUIDataWithRules(){
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationPassed.value = emailResult.status && passwordResult.status

    }
    private  fun checkUserInFirebase(email:String, password:String){

        logInProgress.value =true

        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {


                if (it.isSuccessful){
                    logInProgress.value =false
                    LoginRouter.navigateTo(Screen.Sample)
                }
            }
            .addOnFailureListener {
                logInProgress.value =false

            }
    }


}