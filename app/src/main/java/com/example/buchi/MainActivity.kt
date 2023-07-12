package com.example.buchi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.buchi.ui.theme.BuchiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuchiTheme {
                // A surface container using the 'background' color from the theme
                BuchiApp()
            }
        }
    }
}
