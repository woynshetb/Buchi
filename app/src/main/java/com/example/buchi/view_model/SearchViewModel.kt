package com.example.buchi.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buchi.R
import com.example.buchi.model.Age
import com.example.buchi.model.Category
import com.example.buchi.model.Gender
import com.example.buchi.model.Pet
import com.example.buchi.network.BuchiApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface SearchUiState {
    data class Success(val filteredPets: List<Pet> = listOf(), var searchCategories:List<Category> = listOf<Category>(
        Category("Dogs", title = "A man's best friend\nsince the beginning!", description = "seek companionship from one of the best human friend ever", image = R.drawable.dog, value = "Dog",),
        Category("Cats", title = "Majestic cute \neven queen !", description = "seek companionship\n" +
                "from one of the magnetic\n" +
                "pets of all time", image = R.drawable.cat, value = "Cat",),
        Category("Others", title = "A man's best friend \n since the begining!", description = "seek companionship \n from one of the magnetic \n pets of all time", image = R.drawable.bird, value = "Dog",),

        )) : SearchUiState
    object Error : SearchUiState
    object Loading : SearchUiState
}


class SearchViewModel (
   var selectedCategory:String
) : ViewModel(
) {

    var genders = listOf<Gender>(
        Gender(
            name = "Female",
            value = "female"

        ),
        Gender(
            name = "Male",
            value = "male"

            ),
    )
    var ages = listOf<Age>(

        Age(name = "Baby", age ="baby"),
        Age(name = "Medium", age ="medium"),


    )

    var sizes= listOf<String>(
        "medium",
        "tiny"


    )
    var goodWithChildrens = listOf<Boolean>(
        true,
        false
    )


    var selectFromPetFinder :Boolean = false
    var selectedGender:String =""
    var type:String=""
    var size:String=""
    var age:String=""
    var good_with_childern:Boolean=true

    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.Loading)

    init {
type = selectedCategory

}

    fun filterPets(){
        val params: MutableMap<String, String> = mutableMapOf()
        params["limit"] = "20"
        params["good_with_childern"]="$good_with_childern"
        if (!type.isNullOrEmpty()) {
            params["type"] = type
        }
        if (!age.isNullOrEmpty()) {
            params["age"] = age
        }
        if (!selectedGender.isNullOrEmpty()) {
            params["gender"] = selectedGender
        }
        if (!size.isNullOrEmpty()) {
            params["size"] = size
        }




        viewModelScope.launch {
            searchUiState = try {
                val  listResult = BuchiApi.retrofitService.getFilteredPets(
                    params=params)



                SearchUiState.Success(filteredPets = listResult.pets)
            }catch (e: IOException){

                SearchUiState.Error
            }
        }
    }


}