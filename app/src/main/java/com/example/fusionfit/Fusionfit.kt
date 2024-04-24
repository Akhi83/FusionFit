package com.example.fusionfit

import android.app.Application
import com.google.firebase.FirebaseApp

class Fusionfit : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}