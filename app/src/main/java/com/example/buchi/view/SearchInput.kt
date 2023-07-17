package com.example.buchi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.ui.theme.BrownPeru
import com.example.buchi.view_model.SearchUiState
import com.example.buchi.view_model.SearchViewModel


@Composable
fun SearchInputPage(
    navController: NavController,
    modifier: Modifier = Modifier,
     selectedCategory: String?
){


    val searchViewModel: SearchViewModel = viewModel()

    searchViewModel.type = selectedCategory

    val searchViewModeliUiState = searchViewModel.searchUiState
   Scaffold(
       backgroundColor = BrownLight,
       topBar = { TopAppBar(
           backgroundColor = Color.White,
           elevation = 0.dp,
           modifier = Modifier
               .fillMaxWidth()
               .wrapContentWidth(align = Alignment.CenterHorizontally),){

           CustomAppBar()





       }

       },
   ) {padding ->  Column (
       modifier.padding(24.dp),
       horizontalAlignment = Alignment.CenterHorizontally

   ){


       when(searchViewModeliUiState){
           is SearchUiState.Success ->{
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   TypeDropDown(
                       searchViewModel = searchViewModel
                   )
                   SortDropDown(searchViewModel = searchViewModel)

               }
               SearchResultListView(navController = navController , pets = searchViewModeliUiState.filteredPets)
           }
           is SearchUiState.Loading ->{
               LoadingComposable()
           }
           else ->{

              Box (
                  modifier = modifier.height(10.dp)
              ){

              }
              Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
              ) {
                  TypeDropDown(
                       searchViewModel = searchViewModel
                  )
                  SortDropDown(searchViewModel = searchViewModel)

              }
              Box (
                  modifier = modifier.height(40.dp)
              ){

              }
              Text(text = "Good With Children", fontSize = 16.sp, color = Color.Gray)
              Box (
                  modifier = modifier.height(6.dp)
              ){

              }
              SecondDropDown(
                  searchViewModel,
              )
              Box (
                  modifier = modifier.height(20.dp)
              ){

              }
              Text(text = "Age", fontSize = 16.sp, color = Color.Black)
              Box (
                  modifier = modifier.height(6.dp)
              ){

              }
              AgeDropDown(searchViewModel,)
              Box (
                  modifier = modifier.height(20.dp)
              ){

              }
              Text(text = "Gender", fontSize = 16.sp, color = Color.Gray)

              Box (
                  modifier = modifier.height(6.dp)
              ){

              }

              GenderDropDown(searchViewModel)
              Box (
                  modifier = modifier.height(20.dp)
              ){

              }
              Text(text = "Sizes", fontSize = 16.sp, color = Color.Gray)

              Box (
                  modifier = modifier.height(6.dp)
              ){

              }
              SizeDropDown(searchViewModel = searchViewModel)
              Box (
                  modifier = modifier.height(20.dp)
              ){

              }
              Row(
                  horizontalArrangement = Arrangement.Start,

                  modifier = modifier.fillMaxWidth(),
                  verticalAlignment = Alignment.CenterVertically
              ) {

                  Switch(
                      checked = searchViewModel.selectFromPetFinder,
                      onCheckedChange = { isChecked ->
                          searchViewModel.selectFromPetFinder = !searchViewModel.selectFromPetFinder
                      },

                      colors =  SwitchDefaults.colors(
                          checkedThumbColor = Color.LightGray,
                          uncheckedThumbColor =  Color.LightGray,
                          checkedTrackColor =BrownDeep,
                          uncheckedTrackColor = Color.LightGray
                      )

                  )
                  Text(text = "Include pet list listed \non pet finer too", color = Color.Black, fontSize = 14.sp)


              }
              Box (
                  modifier = modifier.height(20.dp)
              ){

              }
              IconButton(
                  modifier = modifier.align(alignment = Alignment.CenterHorizontally),
                  onClick = {

                      searchViewModel.filterPets()



                  }) {
                  Column(
                      verticalArrangement = Arrangement.Center,
                      horizontalAlignment = Alignment.CenterHorizontally
                  ) {
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

                      Text(text = "Look", color = BrownPeru, fontSize = 20.sp)
                  }


              }


          }


       }












//
   }
       
       
   }
}


@Composable
fun TypeDropDown(modifier: Modifier = Modifier , searchViewModel: SearchViewModel, ){


    var options = searchViewModel.searchCategories








    var expanded by remember { mutableStateOf(false) }




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
                   vertical = 10.dp
               )
               .fillMaxWidth()
               .align(Alignment.Center)
               .clickable {
                   expanded = !expanded
               },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("${searchViewModel.type}", color = BrownDeep, fontSize = 14.sp)

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
                   .background(Color.White,)
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
                           searchViewModel.type = option.value
                           expanded = !expanded

                       }
                   ) {
                       Text(option.value, color = BrownPeru, fontSize = 12.sp)

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
                               checked = searchViewModel.type == option.value,
                               onCheckedChange = { isChecked ->
                                   searchViewModel.type = option.value
                                   expanded = !expanded
                               },
                               modifier = modifier
                                   .width(10.dp)
                                   .height(10.dp),
                               colors =  SwitchDefaults.colors(
                                   checkedThumbColor = Color.LightGray,
                                   uncheckedThumbColor =  Color.LightGray,
                                   checkedTrackColor =BrownDeep,
                                   uncheckedTrackColor = Color.LightGray
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


    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val dropdownWidth = (screenWidth * 0.9f)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))

            .fillMaxWidth()
            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
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
                .width(dropdownWidth)
                .background(Color.White,)
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))




        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.Transparent,)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .align(Alignment.CenterHorizontally),

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

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val dropdownWidth = (screenWidth * 0.9f)



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
                    vertical = 10.dp
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
                .background(Color.White,)
                .width(dropdownWidth)

                .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                )
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.White,)
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

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val dropdownWidth = (screenWidth * 0.9f)



    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
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
                .background(Color.White,)
                .width(dropdownWidth)

                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.White,)
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


    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val dropdownWidth = (screenWidth * 0.9f)


    var expanded by remember { mutableStateOf(false) }



    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()

            .clickable {
                expanded = !expanded
            }

            .background(Color.White)
    ) {
        Row(

            modifier= modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
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
                .background(Color.White,)
                .width(dropdownWidth)

                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))



        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = modifier
                        .background(Color.White,)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp)),

                    onClick = {

                        searchViewModel.size = option
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


@Composable
fun SortDropDown(modifier: Modifier = Modifier , searchViewModel: SearchViewModel, ){


    var options = searchViewModel.nearest








    var expanded by remember { mutableStateOf(false) }




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
                    vertical = 10.dp
                )
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(text = "Sort by", color = Color.Black, fontSize = 10.sp)
                Text("${searchViewModel.nearValue}", color = BrownDeep, fontSize = 14.sp)
            }

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
                .background(Color.White,)
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
                        searchViewModel.nearValue = option
                        expanded = !expanded

                    }
                ) {
                    Text(option, color = BrownPeru, fontSize = 12.sp)

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
                            checked = searchViewModel.type == option,
                            onCheckedChange = { isChecked ->
                                searchViewModel.nearValue = option
                                expanded = !expanded
                            },
                            modifier = modifier
                                .width(10.dp)
                                .height(10.dp),
                            colors =  SwitchDefaults.colors(
                                checkedThumbColor = Color.LightGray,
                                uncheckedThumbColor =  Color.LightGray,
                                checkedTrackColor =BrownDeep,
                                uncheckedTrackColor = Color.LightGray
                            )

                        )
                    }
//
                }
            }
        }
    }



}
