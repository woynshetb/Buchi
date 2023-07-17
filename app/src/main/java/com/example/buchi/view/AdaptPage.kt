package com.example.buchi.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.view_model.AdaptMeViewModel
import com.example.buchi.view_model.AdaptUiState
import com.example.buchi.view_model.BuchiViewModel

@Composable
fun AdaptPage(navController: NavController, modifier: Modifier = Modifier){

    val adaptViewModel: AdaptMeViewModel = viewModel()
    val adaptUiState = adaptViewModel.adaptUiState
    Scaffold(
        backgroundColor = BrownLight,
        topBar = { TopAppBar(
            backgroundColor = Color.White,
            elevation = 0.dp,
            modifier = modifier
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
        padding ->
        
        Column(
            modifier =modifier.padding(
                horizontal = 30.dp
            )
        ) {
            
            when (adaptUiState){
                
                is AdaptUiState.Loading ->{

                    CircularProgressIndicator()

                }

                else -> {
                    Text(text = "not yet")
                }
            }
            Box(
                modifier = modifier.height(
                    40.dp
                )
            ) {

            }
            Text(text = "We dont know how to reach you ", color = Color.Black, fontSize = 20.sp,
                )
            Box(
                modifier = modifier.height(
                    20.dp
                )
            ) {

            }
            Text(text = "Place your name and phone number, we will \ncontact you asap.", color = Color.Black, )
            Box(
                modifier = modifier.height(
                    20.dp
                )
            ) {

            }
            TextField(
                value = "Phone Number",
                
                onValueChange = {

                },
                modifier = Modifier

                    .padding(horizontal = 16.dp)
                    .background(
                        color = BrownLight
                    ),
                textStyle = MaterialTheme.typography.body1
            )

            TextField(
                value = "Name",
                onValueChange = {

                },
                modifier = Modifier

                    .padding(horizontal = 16.dp)
                    .background(
                        color = BrownLight
                    ),
                textStyle = MaterialTheme.typography.body1
            )

            
            Button(onClick = {
                adaptViewModel.adaptPet()

                if(adaptUiState !==AdaptUiState.Error && adaptUiState!==AdaptUiState.Error ){
                    navController.navigate("success")
                }
            }) {
                Text(text = "Send")
            }



        }

    }
}

