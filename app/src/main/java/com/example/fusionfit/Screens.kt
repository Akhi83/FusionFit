package com.example.fusionfit

sealed class Screens (val  screens: String){
    data object Home:Screens("home")
    data object Profile:Screens("profile")
    data object Settings:Screens("settings")
    data object Diet:Screens("Diet")
    data object Workout:Screens("Workout")
    data object MuscleGainVeg:Screens("MuscleGainVeg")
    data object MuscleGainNonVeg:Screens("MuscleGainNonVeg")
    data object Cardio:Screens("Cardio")
    data object WeightLossExercises:Screens("WeightLossExercises")
    data object WeightLossVeg:Screens("WeightLossVeg")
    data object WeightLossNonVeg:Screens("WeightLossNonVeg")
    data object MuscleBuildingExercises:Screens("MuscleBuildingExercises")
    data object Customized:Screens("Customized")
    data object LoseMuscleCustomized:Screens("LoseMuscleCustomized")
    data object GainMuscleCustomized:Screens("GainMuscleCustomized")

}