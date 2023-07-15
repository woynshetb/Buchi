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
        composable(route = Screens.Home.route){
            HomePage(
                navController=navController,
            )
        }
        composable(route = Screens.DETAIL.route){
            DetailPage(
                navController=navController,
            )
        }
        composable(route = Screens.Favorite.route){
            FavoritePage(
                navController=navController,
            )
        }
        composable(route = Screens.ADAPT.route){
            AdaptPage(
                navController=navController,
            )
        }

        composable(route = Screens.Search.route){
            SearchPage(
                navController=navController,
            )
        }

        composable(route = Screens.SUCCESS.route){
            SuccessPage(
                navController=navController,
            )
        }

        composable(route = Screens.ADAPT.route){
            AdaptPage(
                navController=navController,
            )
        }

    }
}