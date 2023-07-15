package com.example.buchi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.buchi.ui.theme.BuchiTheme
import com.example.iogtestproject.navigation.NavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuchiTheme {
                val navController = rememberNavController()

                NavGraph(
                    navController = navController,
                    modifier = Modifier



                )

            }
        }
    }
}
