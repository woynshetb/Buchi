package com.example.buchi.view


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.buchi.navigation.Screens
import com.example.buchi.ui.theme.BrownDeep

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
            composable("home",
            ) { HomePage(navController) }
            composable("search",


                ) { SearchPage(navController) }
            composable("favorite") { FavoritePage(navController)
            }
            composable(
                "searching/{selectedCategory}",
                arguments = listOf(navArgument("selectedCategory") { type = NavType.StringType })
            ) {
                    backStackEntry ->
                val selectedCategory = backStackEntry.arguments?.getString("selectedCategory")
                SearchInputPage(navController,modifier, selectedCategory)
            }

            composable("detail/{petType}/{petId}/{petGoodWithChildren}/{petGender}/{petSize}/{petPhotos}/{petAge}/{source}",

                arguments = listOf(
                    navArgument("petType") { type = NavType.StringType },
                    navArgument("petId") { type = NavType.StringType },
                    navArgument("petGoodWithChildren") { type = NavType.BoolType },
                    navArgument("petGender") { type = NavType.StringType },
                    navArgument("petSize") { type = NavType.StringType },
                    navArgument("petPhotos") { type = NavType.StringType },
                    navArgument("petAge") { type = NavType.StringType },
                    navArgument("source") { type = NavType.StringType },









                ),
                deepLinks = listOf(
                    navDeepLink { uriPattern = "myapp://detail/{petType}/{petId}/{petGoodWithChildren}/{petGender}/{petSize}/{petPhotos}/{petAge}/{source}" }
                )
                ) {

                    backStackEntry ->
                val petType = backStackEntry.arguments?.getString("petType")
                val petId = backStackEntry.arguments?.getString("petId")
               val petGoodWithChildren = backStackEntry.arguments?.getBoolean("petGoodWithChildren") ?: false
                val petGender = backStackEntry.arguments?.getString("petGender")
                val petSize = backStackEntry.arguments?.getString("petSize")
                val photos = backStackEntry.arguments?.getString("petPhotos")
                val petAge = backStackEntry.arguments?.getString("petAge")
                val source = backStackEntry.arguments?.getString("source")

                DetailPage(navController, petType = "$petType", petId = "$petId", good_with_children =petGoodWithChildren , gender = "$petGender", petSize = "$petSize", photos = "$photos", age = "$petAge", source = "$source" )
            }
            composable("adapt") { AdaptPage(navController)
            }
            composable("success") { SuccessPage(navController)
            }







        }}



    }


@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier=Modifier) {
    val items = listOf(Screens.Home, Screens.Search, Screens.Favorite)
    val currentRoute = currentRoute(navController)


    if(currentRoute =="home" || currentRoute =="search" || currentRoute =="favorite"|| currentRoute =="adapt" || currentRoute =="success"){
        BottomNavigation(
            backgroundColor = Color.White,
            modifier = modifier
                .height(100.dp)
                .navigationBarsPadding(
                )

        ) {



            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon, contentDescription = "", tint = if(currentRoute == item.route)   BrownDeep  else Color.Gray, modifier = modifier.size(35.dp)) },

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


}
@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}



