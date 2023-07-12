package com.example.buchi.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buchi.model.Pet
import com.example.buchi.network.BuchiApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BuchiUiState {
    data class Success(val pets: List<Pet>) : BuchiUiState
    object Error : BuchiUiState
    object Loading : BuchiUiState
}
class BuchiViewModel : ViewModel() {
    var gender:String =""
    var type:String=""
    var size:String=""
    var age:String=""
    var good_with_childern:Boolean=true
    var buchiUiState: BuchiUiState by mutableStateOf(BuchiUiState.Loading)
        private set


    init {
        getAllPets()
    }
    private fun getAllPets() {
        viewModelScope.launch {
            buchiUiState = try {
                val  listResult = BuchiApi.retrofitService.getAllPets(
                    limit = "25512467",
                )
                BuchiUiState.Success(pets = listResult.pets)
            }catch (e: IOException){
                BuchiUiState.Error
            }
        }
    }

    private fun filterPets(){
        val params: MutableMap<String, String> = mutableMapOf()
        params["limit"] = "20"
        params["good_with_childern"]="$good_with_childern"
        if (!type.isNullOrEmpty()) {
            params["type"] = type
        }
        if (!age.isNullOrEmpty()) {
            params["age"] = age
        }
        if (!gender.isNullOrEmpty()) {
            params["gender"] = gender
        }
        if (!size.isNullOrEmpty()) {
            params["size"] = size
        }




        viewModelScope.launch {
            buchiUiState = try {
                val  listResult = BuchiApi.retrofitService.getFilteredPets(
           params=params )
                BuchiUiState.Success(pets = listResult.pets)
            }catch (e: IOException){
                println(e)
                BuchiUiState.Error
            }
        }
    }

}

