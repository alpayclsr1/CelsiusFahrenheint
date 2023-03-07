package com.example.celsiusfahrenheitconverter.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.celsiusfahrenheitconverter.UiState

class HomeViewModel: ViewModel() {

    var uiState by mutableStateOf(UiState())
    fun convertFaToCe(a:String){

        try {
            var c=a.toDouble()
            var d=(c - 32)  * 0.5556
            var s=d.toString()
            uiState=uiState.copy(result=s)

        }catch (e:Exception){
            e.printStackTrace()
        }







    }

    fun convertCeToFa(a:String){

        try {
            var c=a.toDouble()
            var d=(c*1.8)+32
            var s=d.toString()

            uiState=uiState.copy(result=s)


        }catch (e:Exception){
            e.printStackTrace()
        }



    }
}