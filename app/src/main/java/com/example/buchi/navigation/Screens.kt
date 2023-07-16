package com.example.buchi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screens(val route: String, val icon: ImageVector,) {
  object SPLASH: Screens("splash",  Icons.Default.Settings)
  object Home: Screens("home", Icons.Default.Home)
  object  Search:Screens(route = "search", Icons.Default.Search)
  object  MAIN:Screens(route = "main", Icons.Default.Settings)
  object Favorite: Screens("favorite", Icons.Default.Favorite)
  object  DETAIL:Screens(route = "detail", Icons.Default.Settings)
  object  ADAPT:Screens(route = "adapt",  Icons.Default.Settings)
  object  SUCCESS:Screens(route = "success",  Icons.Default.Settings)
  object  SearchInput:Screens(route = "searching",  Icons.Default.Search)




}




