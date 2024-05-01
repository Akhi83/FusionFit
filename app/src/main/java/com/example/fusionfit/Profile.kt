
package com.example.fusionfit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Profile() {
    // Retrieve the current user from Firebase Authentication
    val currentUser = FirebaseAuth.getInstance().currentUser

    // Extract the user's name and email if the user is not null
    val userName = currentUser?.displayName ?: "Unknown"
    val userEmail = currentUser?.email ?: "Unknown"

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

                Text(text = "User Name: $userName")

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Email: $userEmail")
            }
        }
    }
}
