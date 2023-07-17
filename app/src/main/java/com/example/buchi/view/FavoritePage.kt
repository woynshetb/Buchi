package com.example.buchi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownLight

@Composable
fun FavoritePage(navController: NavController, modifier :Modifier = Modifier){
 Scaffold(
     backgroundColor = BrownLight,
     topBar = { TopAppBar(
         backgroundColor = Color.White,
         elevation = 0.dp,
         modifier = modifier
             .fillMaxWidth()
             .wrapContentWidth(align = Alignment.CenterHorizontally),){

         CustomAppBar()






     }

     },
 ) {
     padding->
     Column(
         modifier = modifier.padding()
     ) {

         Box(
             contentAlignment = Alignment.Center,
             modifier = modifier.fillMaxSize()
         ) {

             Column(
                 verticalArrangement = Arrangement.Center,
                 horizontalAlignment = Alignment.CenterHorizontally,
                 modifier = modifier.fillMaxSize()
             ) {

                 Spacer(modifier = Modifier.height(30.dp))
                 Text(text = "Coming Soon", color = Color.Black)
             }


         }

     }


 }
}

