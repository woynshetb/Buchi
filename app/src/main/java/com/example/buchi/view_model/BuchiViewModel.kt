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
    data class Success(val pets: List<Pet>,) : BuchiUiState
    object Error : BuchiUiState
    object Loading : BuchiUiState
}



class BuchiViewModel : ViewModel() {

    var buchiUiState: BuchiUiState by mutableStateOf(BuchiUiState.Loading)
        private set


    var searchCategories:List<Category> = listOf<Category>(
        Category("Dogs", title = "A man's best friend\nsince the beginning!", description = "seek companionship \nfrom one of the best \nhuman friend ever", image = R.drawable.dog, value = "Dog",),
        Category("Cats", title = "Majestic cute \neven queen !", description = "seek companionship\n" +
                "from one of the magnetic\n" +
                "pets of all time", image = R.drawable.cat, value = "Cat",),
        Category("Others", title = "A man's best friend \n since the begining!", description = "seek companionship \n from one of the magnetic \n pets of all time", image = R.drawable.bird, value = "Bird",),

        )


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


}

