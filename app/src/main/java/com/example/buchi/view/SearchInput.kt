package com.example.buchi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.buchi.navigation.Screens
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.view_model.BuchiViewModel
import com.example.buchi.view_model.SearchUiState
import com.example.buchi.view_model.SearchViewModel

@Composable
fun SearchInputPage(
    navController: NavController,
    modifier: Modifier = Modifier,
     selectedCategory: String?
){

    val searchViewModel= SearchViewModel(selectedCategory = "$selectedCategory")
    val searchViewModeliUiState = searchViewModel.searchUiState
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
   ) {padding ->  Column (
       modifier.padding(10.dp),
       horizontalAlignment = Alignment.CenterHorizontally

   ){
       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           CustomDropDown()
           CustomDropDown()
       }
   Box (
       modifier = modifier.height(20.dp)
           ){

   }
       Text(text = "Good With Children", fontSize = 16.sp, color = Color.Gray)
       Box (
           modifier = modifier.height(20.dp)
       ){

       }
       SecondDropDown(
           searchViewModel,
           )
       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       Text(text = "Age", fontSize = 16.sp, color = Color.Gray)
       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       AgeDropDown(searchViewModel,)
       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       Text(text = "Gender", fontSize = 16.sp, color = Color.Gray)
       
       Box (
           modifier = modifier.height(10.dp)
       ){

       }

       GenderDropDown(searchViewModel)
       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       Text(text = "Sizes", fontSize = 16.sp, color = Color.Gray)

       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       SizeDropDown(searchViewModel = searchViewModel)
       Box (
           modifier = modifier.height(10.dp)
       ){

       }
       Row(
     horizontalArrangement = Arrangement.Start,
           modifier = modifier.fillMaxWidth()
       ) {

           Switch(
               checked = searchViewModel.selectFromPetFinder,
               onCheckedChange = { searchViewModel.selectFromPetFinder = it },

               colors =  SwitchDefaults.colors(
                   checkedThumbColor = Color.LightGray, // Color when switch is checked
                   uncheckedThumbColor =  Color.LightGray, // Color when switch is unchecked
                   checkedTrackColor =BrownDeep, // Color for the track when switch is checked
                   uncheckedTrackColor = Color.LightGray // Color for the track when switch is unchecked
               )

           )
           Text(text = "include pet list listed \non petfiner too", color = Color.Black, fontSize = 14.sp)


       }
       IconButton(
           modifier = modifier.align(alignment = Alignment.CenterHorizontally),
           onClick = {

               searchViewModel.filterPets()
               if(searchViewModel.searchUiState != SearchUiState.Loading &&searchViewModel.searchUiState != SearchUiState.Error ){
                   println(searchViewModel.searchUiState)

               }else{

               }

//             navController.navigate(Screens)
           }) {
           Box(
               modifier = Modifier
                   .size(60.dp)
                   .clip(CircleShape)
                   .background(color = BrownDeep),
               contentAlignment = Alignment.Center
           ) {

               Icon(
                   Icons.Rounded.Search,
                   modifier = modifier
                       .size(50.dp),
                   tint = BrownLight,

                   contentDescription = "search"

               )

           }









       }










//
   }
       
       
   }
}


@Composable
fun CustomDropDown(modifier: Modifier = Modifier ){
    var selectedOption by remember { mutableStateOf("Option 1") }

   val options = listOf("Option 1", "Option 2", "Option 3")
    var expanded by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .width(150.dp)

            .background(Color.White)

//                modifier = Modifier
//                .width(150.dp)
//            .background(Color.White)
//
//            .clip(RoundedCornerShape(20.dp))

    ) {
        Row(

           modifier= modifier
               .padding(
                   horizontal = 20.dp,
                   vertical = 6.dp
               )
               .fillMaxWidth()
               .align(Alignment.Center)
               .clickable {
                   expanded = !expanded
               },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("$selectedOption", color = BrownDeep, fontSize = 14.sp)

                if(expanded){
                    Icon(  Icons.Default.KeyboardArrowUp, contentDescription = null, tint =BrownDeep)

                }
                else{
                    Icon(  Icons.Default.KeyboardArrowDown, contentDescription = null, tint = BrownDeep)

                }



        }



           DropdownMenu(
               expanded = expanded,

               onDismissRequest = { expanded = false },
               modifier = modifier
                   .background(Color.Transparent,)
                   .width(150.dp)

                   .padding(10.dp)
                   .clip(RoundedCornerShape(20.dp))



           ) {
               options.forEach { option ->
                   DropdownMenuItem(
                       modifier = modifier
                           .background(Color.Transparent,)
                           .width(170.dp)
                           .clip(RoundedCornerShape(20.dp)),

                       onClick = {
                           selectedOption = option
                           expanded = !expanded

                       }
                   ) {
                       Text(option, color = BrownDeep, fontSize = 12.sp)

                       Box(modifier =modifier.width(
                           40.dp
                       )

                       ) {

                       }
                       Box(
                           modifier = modifier
                               .size(10.dp)

                       ) {
                           Switch(
                               checked = isChecked,
                               onCheckedChange = { isChecked = it },
                               modifier = Modifier
                                   .fillMaxSize(),
                               colors =  SwitchDefaults.colors(
                                   checkedThumbColor = Color.LightGray, // Color when switch is checked
                                   uncheckedThumbColor =  Color.LightGray, // Color when switch is unchecked
                                   checkedTrackColor =BrownDeep, // Color for the track when switch is checked
                                   uncheckedTrackColor = Color.LightGray // Color for the track when switch is unchecked
                               )

                           )
                       }
//
                   }
               }
           }
       }



}

@Composable
fun SecondDropDown(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier  ){

   var options = searchViewModel.goodWithChildrens





    var expanded by remember { mutableStateOf(false) }



    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .width(150.dp)
            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box() {
                
            }
 
            Text("${searchViewModel.good_with_childern}", color = Color.Black, fontSize = 16.sp)

            if(expanded){
                Icon(  Icons.Default.KeyboardArrowUp, contentDescription = null, tint =Color.Black, )

            }
            else{
                Icon(  Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.Black)

            }

        }

        DropdownMenu(
            expanded = expanded,

            onDismissRequest = { expanded = false },
            modifier = modifier
                .background(Color.Transparent,)
                .fillMaxWidth()

                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.Transparent,)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp)),

                    onClick = {

                        searchViewModel.good_with_childern = option
                        expanded = !expanded

                    }
                ) {
                    Text("$option", color = BrownDeep, fontSize = 12.sp)

                    Box(modifier =modifier.width(
                        40.dp
                    )

                    ) {

                    }

//
                }
            }
        }
    }
}



@Composable
fun AgeDropDown(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier  ){

    var options = searchViewModel.ages





    var expanded by remember { mutableStateOf(false) }



    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .width(150.dp)
            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box() {

            }

            Text("${searchViewModel.age}", color = Color.Black, fontSize = 16.sp)

            if(expanded){
                Icon(  Icons.Default.KeyboardArrowUp, contentDescription = null, tint =Color.Black, )

            }
            else{
                Icon(  Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.Black)

            }

        }

        DropdownMenu(
            expanded = expanded,

            onDismissRequest = { expanded = false },
            modifier = modifier
                .background(Color.Transparent,)
                .fillMaxWidth()

                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.Transparent,)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp)),

                    onClick = {

                        searchViewModel.age = option.age
                        expanded = !expanded

                    }
                ) {
                    Text("${option.name}", color = BrownDeep, fontSize = 12.sp)

                    Box(modifier =modifier.width(
                        40.dp
                    )

                    ) {

                    }

//
                }
            }
        }
    }
}


@Composable
fun GenderDropDown(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier  ){

    var options = searchViewModel.genders





    var expanded by remember { mutableStateOf(false) }



    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .width(150.dp)
            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box() {

            }

            Text("${searchViewModel.selectedGender}", color = Color.Black, fontSize = 16.sp)

            if(expanded){
                Icon(  Icons.Default.KeyboardArrowUp, contentDescription = null, tint =Color.Black, )

            }
            else{
                Icon(  Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.Black)

            }

        }

        DropdownMenu(
            expanded = expanded,

            onDismissRequest = { expanded = false },
            modifier = modifier
                .background(Color.Transparent,)
                .fillMaxWidth()

                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.Transparent,)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp)),

                    onClick = {

                        searchViewModel.selectedGender = option.value
                        expanded = !expanded

                    }
                ) {
                    Text("${option.name}", color = BrownDeep, fontSize = 12.sp)

                    Box(modifier =modifier.width(
                        40.dp
                    )

                    ) {

                    }

//
                }
            }
        }
    }
}


@Composable
fun SizeDropDown(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier  ){

    var options = searchViewModel.sizes





    var expanded by remember { mutableStateOf(false) }



    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .width(150.dp)
            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box() {

            }

            Text("${searchViewModel.size}", color = Color.Black, fontSize = 16.sp)

            if(expanded){
                Icon(  Icons.Default.KeyboardArrowUp, contentDescription = null, tint =Color.Black, )

            }
            else{
                Icon(  Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.Black)

            }

        }

        DropdownMenu(
            expanded = expanded,

            onDismissRequest = { expanded = false },
            modifier = modifier
                .background(Color.Transparent,)
                .fillMaxWidth()

                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.Transparent,)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp)),

                    onClick = {

                        searchViewModel.age = option
                        expanded = !expanded

                    }
                ) {
                    Text(option, color = BrownDeep, fontSize = 12.sp)

                    Box(modifier =modifier.width(
                        40.dp
                    )

                    ) {

                    }

//
                }
            }
        }
    }
}