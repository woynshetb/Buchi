package com.example.buchi.view


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.ui.theme.BrownWarm
import com.example.buchi.ui.theme.TextFormBG
import com.example.buchi.view_model.AdaptMeViewModel
import com.example.buchi.view_model.AdaptUiState

@Composable
fun AdaptPage(navController: NavController, modifier: Modifier = Modifier){
    var nameText by remember { mutableStateOf("") }
    var phoneText by remember { mutableStateOf("") }


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

            CustomAppBar()






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

                    LoadingComposable()

                }
                is AdaptUiState.Error ->{
                    ErrorPage(navController = navController)

                }




                else -> {
                    Box(
                        modifier = modifier.height(
                            60.dp
                        )
                    ) {

                    }
                    Text(text = "We don't know how to reach you ", color = Color.Black, fontSize = 20.sp,
                    )
                    Box(
                        modifier = modifier.height(
                            40.dp
                        )
                    ) {

                    }
                    Text(text = "Place your name and phone number, we will \ncontact you asap.", color = Color.Black, )
                    Box(
                        modifier = modifier.height(
                            40.dp
                        )
                    ) {

                    }
                    TextField(
                        value = nameText,
                        placeholder = {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = androidx.compose.ui.Alignment.Center
                            ) {
                                Text(
                                    text = "Name",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                )
                            }


                            },



                        onValueChange = {newValue->

                                nameText = newValue


                        },
                        modifier = Modifier


                            .fillMaxWidth()
                            .background(
                                color = TextFormBG
                            ).border(
                                width = 0.dp,
                                color = Color.Transparent,


                            ),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                    )
                    Box(
                        modifier = modifier.height(
                            24.dp
                        )
                    ) {

                    }
                    TextField(
                        value = phoneText,

                        placeholder = {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = androidx.compose.ui.Alignment.Center
                            ) {
                                Text(
                                    text = "Phone Number",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                )
                            }


                            },


                        onValueChange = {newValue->

                                phoneText = newValue

                        },
                        modifier = Modifier


                            .fillMaxWidth()
                            .background(
                                color = TextFormBG
                            ).border(
                                width = 0.dp,
                        color = Color.Transparent,

                    ),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                    )

                    Column(modifier.weight(1.0f)) {

                    }


                    Column(


                        modifier = modifier.width(200.dp).height(50.dp).background(
                            color = BrownWarm,
                            shape =  RoundedCornerShape(20.dp)
                        ).align(Alignment.CenterHorizontally).clickable {

                            adaptViewModel.adaptPet(nameValue = nameText, phoneNumber=phoneText,)

                            if(adaptUiState ==AdaptUiState.Success){
                                navController.navigate("success")
                            }
                        }  .clip(RoundedCornerShape(20.dp)),
                        verticalArrangement = Arrangement.Center
                        ) {
                        Text(text = "Send", fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                    Column(modifier.weight(1.0f)) {

                    }
                }
            }





        }

    }
}

