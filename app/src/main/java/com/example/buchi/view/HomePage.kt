package com.example.buchi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.view_model.BuchiUiState
import com.example.buchi.view_model.BuchiViewModel
import com.example.buchi.view_model.SearchUiState
import com.example.buchi.view_model.SearchViewModel

@Composable

fun HomePage(
    navController: NavController
){



    val buchiUiViewModel: BuchiViewModel = viewModel()



    val buchiUiState = buchiUiViewModel.buchiUiState



   Scaffold(
       backgroundColor = BrownLight,
       topBar = { TopAppBar(
           backgroundColor = Color.White,
           elevation = 0.dp,
           modifier = Modifier
               .fillMaxWidth()
               .wrapContentWidth(align = Alignment.CenterHorizontally),){

           CustomAppBar()





       }

       },
   ) {
       
       padding->
       Column(
           modifier = Modifier.padding()
       ) {
           when(buchiUiState){
               is BuchiUiState.Success ->{
                   
                   SearchResultListView(navController = navController , pets = buchiUiState.pets)
               }
               is BuchiUiState.Loading ->{
                   LoadingComposable()
               }
               else ->{
                   
                   ErrorPage(navController = navController)
                   
               }
           
           }
           
       }
       
   }


}
