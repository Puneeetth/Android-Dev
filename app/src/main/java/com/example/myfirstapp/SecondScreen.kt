package com.example.myfirstapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, count: String?){
    Column() {
        Text(text = "Receive count $count")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Go Back")
        }
    }
}
