package com.example.buchi.view

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.buchi.view_model.BuchiUiState

@Composable

fun HomePage(
    navController: NavController
){





    //buchiUiState: BuchiUiState, modifier: Modifier = Modifier


    Text(text = "HOME")

//    when (buchiUiState) {
//       is BuchiUiState.Success ->  Text(text = buchiUiState.pets.toString() )
//        is BuchiUiState.Loading ->  CircularProgressIndicator()
//        is BuchiUiState.Error -> Text(text = "Error")
//    }
//


}
