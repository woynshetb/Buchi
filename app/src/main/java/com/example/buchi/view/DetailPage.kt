package com.example.buchi.view

import android.os.Parcelable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import com.example.buchi.model.Pet

import androidx.navigation.NavArgsLazy
import androidx.viewpager2.widget.ViewPager2
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.buchi.R
import com.example.buchi.model.PhotoData
import com.example.buchi.navigation.Screens
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DetailPage(navController: NavController, modifier: Modifier = Modifier, petType:String , petId: String , good_with_children :Boolean , gender:String, petSize :String , photos:String, age:String, source:String){


    val photoList = parseJsonToPhotoList(photos)


    val imageList = mutableListOf<Int>()
    var placeHolderImage :Int






    var pet = Pet(type = petType, pet_id = petId, good_with_children = good_with_children, gender = gender, size = petSize, photos = photoList, age =age, source = source)

    placeHolderImage = if (pet.type =="cat"|| pet.type =="Cat"){
        imageList.add( R.drawable.cat,)
        R.drawable.cat
    }
    else if(pet.type =="dog"|| pet.type =="Dog") {
        imageList.add( R.drawable.dog,)
        R.drawable.dog
    }
    else{
        imageList.add( R.drawable.bird,)
        R.drawable.bird
    }


    Scaffold(

      backgroundColor = Color.Black,
      topBar = { TopAppBar(
          backgroundColor = Color.White,
          elevation = 0.dp,
          modifier = Modifier
              .fillMaxWidth()
              .wrapContentWidth(align = Alignment.CenterHorizontally),){

          Row( modifier = Modifier.fillMaxWidth(),


              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically

          ){
              Box(
                  modifier = modifier.width(20.dp)
              ) {

              }
              Row() {
                  // logo here
                  Text(
                      "Buchi",
                      fontWeight = FontWeight.W900,
                      color = BrownDeep,


                      )
              }

              IconButton(onClick = {

              }) {
                  Icon(
                      Icons.Rounded.Menu,
                      modifier = modifier
                          .size(20.dp),
                      tint = BrownDeep,

                      contentDescription = "menu"

                  )


              }
          }




      }

      },
  ) {
      padding->
      Column(
          modifier = modifier.padding(0.dp)
      ) {


          Column(modifier.weight(1f)) {
              ImageSlider(
                  photos = photoList,
                  placeHolder = placeHolderImage,
                  placeholders = imageList

              )
          }

          // Second Column
          Column(
              modifier
                  .weight(2f)
                  .fillMaxWidth()
                  .clip(
                      shape = MaterialTheme.shapes.medium.copy(
                          topStart = CornerSize(16.dp),
                          topEnd = CornerSize(16.dp)
                      )
                  )
                  .padding(
//                      vertical = 20.dp,
//                      horizontal = 10.dp,

                  )
                  .background(color = BrownLight)
                 ) {
              Box (
                  modifier = modifier.height(
                      20.dp
                  )
              ){

              }

              Text(text = "${pet.type}", fontSize = 20.sp, color = BrownDeep , fontWeight = FontWeight.Bold, modifier = modifier.padding(horizontal = 20.dp,))

              Divider(
                  color = Color.Black,
                  thickness = 0.8.dp,
                  modifier = Modifier
                      .padding(vertical = 8.dp)
                      .fillMaxWidth()
              )
              Box (
                  modifier = modifier.height(
                      20.dp
                  )
              ){

              }
              if(pet.good_with_children){
                  Text(text = "Good with Children ", color = Color.Black ,modifier = modifier.padding(horizontal = 20.dp))
              }else{
                  Text(text = "Not Good with Children ", color = Color.Black ,modifier = modifier.padding(horizontal = 20.dp))
              }


              Divider(
                  color = Color.Black,
                  thickness = 0.8.dp,
                  modifier = Modifier
                      .padding(vertical = 8.dp)
                      .fillMaxWidth()
              )
              Box (
                  modifier = modifier.height(
                      10.dp
                  )
              ){

              }
              Text(text = "Age: ${pet.age} ",color = Color.Black ,modifier = modifier.padding(horizontal = 20.dp))

              Divider(
                  color = Color.Black,
                  thickness = 0.8.dp,
                  modifier = Modifier
                      .padding(vertical = 8.dp)
                      .fillMaxWidth()
              )
              Box (
                  modifier = modifier.height(
                      10.dp
                  )
              ){

              }
              Text(text = "Gender : ${pet.gender} ",modifier = modifier.padding(horizontal = 20.dp),color = Color.Black )

              Divider(
                  color = Color.Black,
                  thickness = 0.8.dp,
                  modifier = Modifier
                      .padding(vertical = 8.dp)
                      .fillMaxWidth()
              )
              Box (
                  modifier = modifier.height(
                      10.dp
                  )
              ){

              }
              Text(text = "Size : ${pet.size} ",modifier = modifier.padding(horizontal = 20.dp),color = Color.Black )

              Divider(
                  color = Color.Black,
                  thickness = 0.8.dp,
                  modifier = Modifier
                      .padding(vertical = 8.dp)
                      .fillMaxWidth()
              )
              Box (
                  modifier = modifier.height(
                      10.dp
                  )
              ){

              }
              IconButton(
                  modifier = modifier.align(alignment = Alignment.CenterHorizontally),
                  onClick = {
  navController.navigate("adapt")
                  }) {
                  Column(
                     
                         
                   
                  ) {

                      Icon(
                          Icons.Rounded.Favorite,
                          modifier = modifier
                              .size(80.dp),
                          tint = BrownDeep,

                          contentDescription = "search"

                      )
                      
                      Text(text = "Adapt Me", color = BrownDeep, fontSize = 20.sp)


                  }









              }

          }



      }

  }
}

@Composable
fun ImageSlider( modifier: Modifier = Modifier, photos: List<PhotoData>, placeholders:List<Int>, placeHolder:Int) {
    var currentImageIndex by remember { mutableStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    println(placeholders)


    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
            )) {
            // Scrollable Row of Cards
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                if(photos.isNotEmpty()){
                    itemsIndexed(photos) { index, image ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
//                                horizontal = 16.dp,
//                                vertical = 16.dp
                                )
                                .fillMaxHeight()
                                .background(color = Color.Transparent)
                                .clickable {
                                    if (index != currentImageIndex && !isAnimating) {
                                        isAnimating = true
                                        coroutineScope.launch {
                                            val delayMillis = 500L
                                            // Wait for the card to change color before animating
                                            delay(delayMillis / 2)
                                            currentImageIndex = index
                                            delay(delayMillis)
                                            isAnimating = false
                                        }
                                    }
                                },

                            ) {


                            AsyncImage(
                                modifier = modifier
                                    .padding(

                                        horizontal = 20.dp
                                    )

                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                ,
                                model = ImageRequest.Builder(context = LocalContext.current)
                                    .data(image.url)
                                    .crossfade(true)
                                    .build(),



                                error = painterResource(  placeHolder),
                                placeholder = painterResource(placeHolder),
                                contentDescription = stringResource(com.google.android.material.R.string.icon_content_description),
                                contentScale = ContentScale.FillBounds
                            )

                        }
                    }

                }else{
                    itemsIndexed(placeholders) { index, image ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
//                                horizontal = 16.dp,
//                                vertical = 16.dp
                                )
                                .fillMaxHeight()
                                .background(color = Color.Transparent)
                                .clickable {
                                    if (index != currentImageIndex && !isAnimating) {
                                        isAnimating = true
                                        coroutineScope.launch {
                                            val delayMillis = 500L
                                            // Wait for the card to change color before animating
                                            delay(delayMillis / 2)
                                            currentImageIndex = index
                                            delay(delayMillis)
                                            isAnimating = false
                                        }
                                    }
                                },

                            ) {

                            Image(
                                painter = painterResource(image),
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth,
                                                                modifier = modifier
                                    .padding(

                                        horizontal = 20.dp
                                    )

                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            )
//                            AsyncImage(
//                                modifier = modifier
//                                    .padding(
//
//                                        horizontal = 20.dp
//                                    )
//
//                                    .fillMaxWidth()
//                                    .fillMaxHeight()
//                                ,
//                                model = ImageRequest.Builder(context = LocalContext.current)
//                                    .data(image)
//                                    .crossfade(true)
//                                    .build(),
//
//
//
//                                error = painterResource(  image),
//                                placeholder = painterResource(image),
//                                contentDescription = stringResource(com.google.android.material.R.string.icon_content_description),
//                                contentScale = ContentScale.FillBounds
//                            )

                        }
                    }

                }

            }

        }
    }
}
 fun parseJsonToPhotoList(json: String?): List<PhotoData> {
    return try {
        val gson = Gson()
        val photoArray = gson.fromJson(json, Array<PhotoData>::class.java)
        photoArray.filterNotNull()
    } catch (e: Exception) {
        emptyList()
    }
}
