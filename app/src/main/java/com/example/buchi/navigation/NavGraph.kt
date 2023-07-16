package com.example.iogtestproject.navigation



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.buchi.navigation.Screens
import com.example.buchi.view.*


@Composable
fun NavGraph (navController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navController,
        startDestination = Screens.SPLASH.route)
    {

        composable(route = Screens.SPLASH.route){
            SpashPage(
                navController=navController,
            )
        }
        composable(route = Screens.MAIN.route){
            MainPage(
                navController=navController,
            )
        }




    }
}