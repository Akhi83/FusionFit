package com.example.fusionfit.data



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel : ViewModel() {

    data class UserState(
        val firstName: String = "",
        val lastName: String = "",
        val email: String = ""
    )

    var firstName = mutableStateOf("")
    var lastName = mutableStateOf("")
    var email = mutableStateOf("")

    // Function to update the first name
    fun setFirstName(value: String) {
        firstName.value = value
    }

    // Function to update the last name
    fun setLastName(value: String) {
        lastName.value = value
    }

    // Function to update the email
    fun setEmail(value: String) {
        email.value = value
    }
    val userState = mutableStateOf(UserState())

    init {
        // Load user data when the ViewModel is initialized
        loadUserData()
    }

    private fun loadUserData() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        currentUser?.let {
            // Extract user data
            val firstName = currentUser.displayName?.split(" ")?.getOrNull(0) ?: ""
            val lastName = currentUser.displayName?.split(" ")?.getOrNull(1) ?: ""
            val email = currentUser.email ?: ""

            // Update user state
            userState.value = UserState(firstName, lastName, email)
        }
    }
}
