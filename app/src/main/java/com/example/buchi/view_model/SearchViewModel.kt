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
    data class Success(val filteredPets: List<Pet> = listOf(), ) : SearchUiState
    object Error : SearchUiState
    object Loading : SearchUiState
    object Initial :SearchUiState
}


class SearchViewModel (

) : ViewModel(
) {
    var searchCategories:List<Category> = listOf<Category>(
        Category("Dogs", title = "A man's best friend\nsince the beginning!", description = "seek companionship \nfrom one of the best \nhuman friend ever", image = R.drawable.dog, value = "Dog",),
        Category("Cats", title = "Majestic cute \neven queen !", description = "seek companionship\n" +
                "from one of the magnetic\n" +
                "pets of all time", image = R.drawable.cat, value = "Cat",),
        Category("Bird", title = "A man's best friend \n since the begining!", description = "seek companionship \n from one of the magnetic \n pets of all time", image = R.drawable.bird, value = "Bird",)
        ,

        Category("Mice", title = "A man's best friend \n since the begining!", description = "seek companionship \n from one of the magnetic \n pets of all time", image = R.drawable.mice, value = "mice",),


        )
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
        Age(name="Puppy", age= "puppy"),
        Age(name="Young", age= "young"),

        Age(name = "Medium", age ="medium"),
        Age(name = "Adult", age = "adult" ),
        Age(name = "Senior", age = "senior" ),


    )

    var sizes= listOf<String>(
        "medium",
        "tiny",
        "large",
        "xlarge",







    )
    var goodWithChildrens = listOf<Boolean>(
        true,
        false
    )


    var nearest= listOf<String>(
        "nearest",
        "all",
    )


    var selectFromPetFinder :Boolean = false
    var selectedGender:String =""
    var type:String?=""
    var size:String=""
    var age:String=""
    var good_with_childern:Boolean=true

    var nearValue :String?=""


    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.Initial)



    init {


}

    fun filterPets(){
        searchUiState = SearchUiState.Loading

   val params: MutableMap<String, String> = mutableMapOf()
      params["limit"] = "100"
        params["good_with_children"]="$good_with_childern"
        if (!type.isNullOrEmpty()) {
            params["type"] = "$type"
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


        println(params)




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