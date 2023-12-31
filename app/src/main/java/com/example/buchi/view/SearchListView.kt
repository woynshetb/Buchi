package com.example.buchi.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.buchi.R
import com.example.buchi.model.Pet
import com.google.gson.Gson

@Composable

fun SearchResultListView(
    navController: NavController,
    pets:List<Pet>,
    modifier:Modifier = Modifier
){
    val alpha = remember { mutableStateOf(0.0f) }




    LazyColumn {

        itemsIndexed(pets){
                index , pet -> Box()
        {


            Column(
                modifier = modifier.clickable {

//                    val route = "detail/${pet.type}?/$petId&petName=$petName"
//                    navController.navigate(route)

//  val route = "detail/$petId?otherArgument=$otherArgument"
//                    navController.navigate(route)


                    var listOfUrl = pet.photos.map{data->{
                        data.url ?: ""
                    } }


                    val petPhotosToJson = Gson().toJson(listOfUrl)


                    var route="detail/${pet.type}/${pet.good_with_children}/${pet.gender}/${pet.size}/${petPhotosToJson}/${pet.age}/${pet.source}";
                    navController.navigate(route)
                   // navController.navigate("detail/${pet.type}/${pet.pet_id}")

                   // navController.navigate("detail")
                }
            ) {



               Box {
                   AsyncImage(
                       modifier = modifier
                           .padding(
                               vertical = 20.dp,
                               horizontal = 20.dp
                           )

                           .fillMaxWidth()
                           .aspectRatio(1.5f) ,
                       model = ImageRequest.Builder(context = LocalContext.current)
                           .data(pet.photos)
                           .crossfade(true)
                           .build(),



                       error = painterResource(  getPlaceholderImage(type = pet.type)),
                       placeholder = painterResource(getPlaceholderImage(type = pet.type)),
                       contentDescription = stringResource(com.google.android.material.R.string.icon_content_description),
                       contentScale = ContentScale.FillBounds
                   )
                   Text(
                       text = pet.type[0].toString(),
                       fontSize = 60.sp,

                       color = Color.Black,
                       textAlign = TextAlign.Center,

                       modifier = Modifier
                           .align(Alignment.BottomEnd)
                           .padding(
                               vertical = 30.dp,
                               horizontal = 40.dp
                           )
                           ,
                       fontWeight = FontWeight.W900

                   )




               }


            }



            
                    
            
        }
        }
    }
    if(pets.isEmpty()){
        EmptyList(navController =navController)
    }

}


fun getPlaceholderImage( type:String) : Int {
    var imageUrl:Int

    if(type =="Cat"||type=="cat"){
        imageUrl = R.drawable.cat

    }
    else if (type =="Dog"|| type =="dog"){
        imageUrl =R.drawable.dog
    }
    else if (type =="Bird" || type =="bird"){
        imageUrl = R.drawable.bird
    }
    else if(type =="mice" || type =="Mice"){
        imageUrl = R.drawable.mice
    }
    else{
        imageUrl = R.drawable.splash_dog
    }

  return imageUrl
}

private fun parseJsonToStringList(json: String?): List<String> {
    return try {
        val gson = Gson()
        gson.fromJson(json, Array<String>::class.java).toList()
    } catch (e: Exception) {
        emptyList()
    }
}