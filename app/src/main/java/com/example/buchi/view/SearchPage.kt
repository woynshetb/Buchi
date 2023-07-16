package com.example.buchi.view

import android.widget.ListView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.buchi.model.Category
import com.example.buchi.navigation.Screens
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.view_model.BuchiUiState
import com.example.buchi.view_model.BuchiViewModel

@Composable
fun SearchPage(navController: NavController, modifier : Modifier = Modifier){

    val buchiViewModel: BuchiViewModel = viewModel()
    val buchiUiState = buchiViewModel.buchiUiState

    Scaffold(
        backgroundColor = BrownLight,
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
            padding ->  Column(
        modifier = modifier.padding(0.dp)
    ){
            when (buchiUiState) {
       is BuchiUiState.Success ->  CategoryList(categoryList= buchiUiState.searchCategories, navController = navController)
        is BuchiUiState.Loading ->  CircularProgressIndicator()
        is BuchiUiState.Error -> Text(text = "Error")
                else -> Text(text = "Error")
    }
    }
    }


}
@Composable
fun CategoryList(categoryList: List<Category>, modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {

        itemsIndexed(categoryList) { index , category ->
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(start = 40.dp, top = 30.dp, end = 40.dp, bottom = 10.dp  ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = MaterialTheme.colors.primary
                ),
                elevation = ButtonDefaults.elevation(0.dp),
                contentPadding = PaddingValues(0.dp),


                onClick = {
                    navController.navigate("searching/${category.value}")

                // go to add input page
            }) {
                CategoryCard(category = category, isRight = ((index+1)%2) ==0 )
            }
        }
    }
}

@Composable
fun CategoryCard(
     isRight :Boolean ,
     modifier: Modifier = Modifier,
     category: Category
){




    Card(modifier = modifier
        .clip(RoundedCornerShape(20.dp))
        .fillMaxWidth(),
    backgroundColor = Color.White,

        )    {

        if(isRight){
            RightCardBody(category=category)
        }
        else{
           LeftCardBody(category = category)
        }


    }
}

@Composable
fun LeftCardBody(
    category: Category,
    modifier: Modifier = Modifier
){
    Row(

    ) {



        Image(
            painter = painterResource(category.image),
            contentDescription = "",
            contentScale = ContentScale.FillHeight,
            modifier = modifier
                .height(150.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(20.dp))

        )

        Column(
            modifier = modifier.padding(top = 20.dp, end = 10.dp),
            horizontalAlignment = Alignment.End
        ) {

            Text(text = category.categoryTitle, color = BrownDeep, fontSize = 20.sp,textAlign = TextAlign.Right,)
            Text(text = category.title, fontSize = 14.sp, textAlign = TextAlign.Right, fontWeight = FontWeight.W400)
            Text(text = category.description, fontWeight = FontWeight.Light,textAlign = TextAlign.Right, color = Color.Gray, fontSize = 12.sp)



        }


    }
}
@Composable
fun RightCardBody(
    category: Category,
    modifier: Modifier = Modifier
){
    Row(
   horizontalArrangement = Arrangement.SpaceBetween
    ) {



        Column(
            modifier = modifier.padding(top = 20.dp, start = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = category.categoryTitle, color = BrownDeep, fontSize = 20.sp,textAlign = TextAlign.Left)
            Text(text = category.title, fontSize = 14.sp, textAlign = TextAlign.Left,fontWeight = FontWeight.W400)
            Text(text = category.description, fontWeight = FontWeight.Light,textAlign = TextAlign.Left, color = Color.Gray, fontSize = 12.sp)



        }

        Image(
            painter = painterResource(category.image),
            contentDescription = "",
            contentScale = ContentScale.FillHeight,
            modifier = modifier
                .height(150.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(20.dp))

        )



    }

}