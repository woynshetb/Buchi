package com.example.buchi.view

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
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight

@Composable
fun SearchPage(navController: NavController, modifier : Modifier = Modifier){
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

                IconButton(onClick = { /*TODO*/ }) {
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
            padding ->Column() {

        }
    }


}

