package com.example.buchi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun ErrorPage(navController: NavController, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()

    ) {


        Text(text ="Error Occured while fetching Data " )
        Spacer(modifier = modifier.height(10.dp))


        Button(onClick = {   navController.navigate("${navController.graph.startDestinationRoute}") }) {
            
            
            Text(text = "Go Back")


          
        }



    }


}