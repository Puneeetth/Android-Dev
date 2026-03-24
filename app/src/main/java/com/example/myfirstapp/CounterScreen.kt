package com.example.myfirstapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Counter(navController: NavController){
    var count by remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    var input by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("second/$count")
        }) { Text("Go to Second Screen")}
        TextField(
            value = input,
            onValueChange = {input = it},
            label = {Text("Enter Number")}
        )
        val color = if(count > 5) Color.Red else Color.Green
        Text("Count : $count",
            fontSize = 30.sp,
            color = color
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if(count < 10) {
                count++
            }
            count = input.toIntOrNull() ?: count
            Toast.makeText(context,"Increased", Toast.LENGTH_SHORT).show()
        }) {Text(text = "Increase",
            fontSize = 18.sp)}
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if(count > 0) {
                count--
            }
            Toast.makeText(context,"Decreased",Toast.LENGTH_SHORT).show()
        }) {Text("Decrease") }
        Button(onClick = {
            count = 0
        }) {Text("Reset") }

    }

}