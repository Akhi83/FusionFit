package com.example.fusionfit.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fusionfit.LoginRouter
import com.example.fusionfit.Screen
import com.example.fusionfit.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignUpViewModel : ViewModel() {

        var registrationUIState = mutableStateOf(RegistrationUIState())

        var allValidationPassed = mutableStateOf(false)

        var signUpInProgress = mutableStateOf(false)


        fun onEvent(event:SignupUIEvent){

            validateDataWithRules()
            when(event){
                is SignupUIEvent.FirstNameChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        firstName= event.firstName
                    )

                }
                is SignupUIEvent.LastNameChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        lastName= event.lastName
                    )
                }
                is SignupUIEvent.EmailChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        email = event.email
                    )
                }
                is SignupUIEvent.PasswordChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        password= event.password
                    )
                }
                is SignupUIEvent.RegisterButtonClicked ->{
                    signUp()
                }


            }
        }
    private fun signUp(){
        createUserInFirebase(
            email =registrationUIState.value.email ,
            password = registrationUIState.value.password
        )
    }
    private fun validateDataWithRules(){
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = registrationUIState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )
        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationPassed.value = fNameResult.status && lNameResult.status &&
                emailResult.status && passwordResult.status


    }

     private  fun createUserInFirebase(email:String, password:String){

//         signUpInProgress.value =true

         FirebaseAuth.getInstance()
             .createUserWithEmailAndPassword(email,password)
             .addOnCompleteListener {


                 if (it.isSuccessful){
//                     signUpInProgress.value =false
                     LoginRouter.navigateTo(Screen.Sample)
                 }
             }
             .addOnFailureListener {
//                 signUpInProgress.value =false

             }
    }

    fun logout(){
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val authStateListener =AuthStateListener{
            if(it.currentUser == null){
                LoginRouter.navigateTo(Screen.LoginScreen)

            }else{

            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }
}