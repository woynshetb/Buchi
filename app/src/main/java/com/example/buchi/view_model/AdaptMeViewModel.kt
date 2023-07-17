package com.example.buchi.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController

import com.example.buchi.model.AdaptResponse
import com.example.buchi.model.Customer
import com.example.buchi.network.BuchiApi
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface AdaptUiState {
    object Success :AdaptUiState
    object Error : AdaptUiState
    object Loading : AdaptUiState
    object Initial:AdaptUiState
}
class AdaptMeViewModel (
) : ViewModel(
){
    var adaptUiState: AdaptUiState by mutableStateOf(AdaptUiState.Initial)
        private set





      fun adaptPet(nameValue :String, phoneNumber:String,){



           if(nameValue.isNotEmpty()&& phoneNumber.isNotEmpty()){
               adaptUiState = AdaptUiState.Loading
               viewModelScope.launch{
                   adaptUiState = try {
                       val user = Customer( nameValue,  phoneNumber)
                       val response = BuchiApi.retrofitService.add(user)

                       AdaptUiState.Success


                   }
                   catch (e: IOException){
                       AdaptUiState.Error

                   }
           }




    }


    }

}