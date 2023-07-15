package com.example.buchi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.rounded.Menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


import com.example.buchi.navigation.Screens
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.example.iogtestproject.navigation.NavGraph

@Composable
fun MainPage(navController: NavController, modifier: Modifier = Modifier,){


    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "search",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { HomePage(navController) }
            composable("search") { SearchPage(navController) }
            composable("favorite") { FavoritePage(navController) }
        }}



    }


@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier=Modifier) {
    val items = listOf(Screens.Home, Screens.Search, Screens.Favorite)
    BottomNavigation(
        backgroundColor = Color.White,
      modifier = modifier.height(  100.dp).navigationBarsPadding(
      )

    ) {

        val currentRoute = currentRoute(navController)

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = "", tint = BrownDeep, modifier = modifier.size(35.dp)) },

                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

