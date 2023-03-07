package com.example.celsiusfahrenheitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.celsiusfahrenheitconverter.screens.Home
import com.example.celsiusfahrenheitconverter.ui.theme.CelsiusFahrenheitConverterTheme
import com.example.celsiusfahrenheitconverter.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<HomeViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            CelsiusFahrenheitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Home(homeViewModel = viewModel)
                }
            }
        }
    }
}
