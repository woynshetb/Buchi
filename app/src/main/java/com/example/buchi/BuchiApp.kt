package com.example.buchi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buchi.view.HomePage
import com.example.buchi.view_model.BuchiViewModel

@Composable
fun BuchiApp(){

    Scaffold(

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val buchiViewModel: BuchiViewModel = viewModel()
            HomePage(
                buchiUiState = buchiViewModel.buchiUiState)
        }
    }
}



