package com.example.buchi.view

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.buchi.view_model.BuchiUiState

@Composable

fun HomePage(
    buchiUiState: BuchiUiState, modifier: Modifier = Modifier
){

    when (buchiUiState) {
       is BuchiUiState.Success ->  Text(text = buchiUiState.pets.toString() )
        is BuchiUiState.Loading ->  CircularProgressIndicator()
        is BuchiUiState.Error -> Text(text = "Error")
    }
   


}
