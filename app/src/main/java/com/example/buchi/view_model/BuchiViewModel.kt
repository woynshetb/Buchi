package com.example.buchi.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.buchi.R
import com.example.buchi.model.Category
import com.example.buchi.model.Customer
import com.example.buchi.model.Pet
import com.example.buchi.network.BuchiApi
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject
import java.io.IOException

sealed interface BuchiUiState {
    data class Success(val pets: List<Pet>,var searchCategories:List<Category> = listOf<Category>(
        Category("Dogs", title = "A man's best friend\nsince the begining!", description = "seek companionship from one of the best human friend ever", image = R.drawable.dog, value = "Dog",),
        Category("Cats", title = "Magestic cute \n even queen !", description = "seek companionship from one of the best human friend ever", image = R.drawable.cat, value = "Cat",),
        Category("Others", title = "A man's best friend since the begining!", description = "seek companionship from one of the best human friend ever", image = R.drawable.bird, value = "Dog",),

    )) : BuchiUiState
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
   private  fun adaptPet(){ viewModelScope.launch{
       try {
           val user =Customer( "woynshet",  "0964001822")
           val response = BuchiApi.retrofitService.add(user)







       }
       catch (e:IOException){
           println("*******************************")
           println(e.message)
           println("*******************************")

       }


   }


   }


}

