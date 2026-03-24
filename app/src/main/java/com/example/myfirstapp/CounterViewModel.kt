package com.example.myfirstapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var count by mutableStateOf(0)
        private set

    fun increase(){
        if(count < 10) count++
    }
    fun decrease(){
        if(count > 0) count--
    }
    fun reset(){
        count = 0
    }
}