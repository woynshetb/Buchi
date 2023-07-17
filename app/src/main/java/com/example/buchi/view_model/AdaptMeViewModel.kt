package com.example.buchi.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.buchi.model.AdaptResponse
import com.example.buchi.model.Customer
import com.example.buchi.network.BuchiApi
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface AdaptUiState {
    data class Success(var apiResult: AdaptResponse) : SearchUiState, AdaptUiState
    object Error : AdaptUiState
    object Loading : AdaptUiState
}
class AdaptMeViewModel (
) : ViewModel(
){
    var adaptUiState: AdaptUiState by mutableStateOf(AdaptUiState.Loading)
        private set

      fun adaptPet(){ viewModelScope.launch{
       adaptUiState = try {
            val user = Customer( "woynshet",  "0964001822")
            val response = BuchiApi.retrofitService.add(user)
println(response)
            AdaptUiState.Success(apiResult = response)


        }
        catch (e: IOException){
       AdaptUiState.Error

        }


    }


    }

}