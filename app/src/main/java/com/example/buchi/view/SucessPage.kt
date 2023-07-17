package com.example.buchi.view



import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight

@Composable
fun SuccessPage(navController: NavController, modifier: Modifier = Modifier){
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
    padding->
    Column(
        modifier = modifier.padding(
            vertical = 40.dp,
            horizontal = 30.dp
        )
    ) {
        Box(
            modifier = modifier.height(80.dp)
        ) {

        }

        Text(text = "Congratulations", color = BrownDeep, fontSize = 44.sp, fontWeight = FontWeight.W900 )
        Box(
            modifier = modifier.height(40.dp)
        ) {

        }
        Text(text = "We will set up a meeting with your companion soon :)", color=Color.Black)
        Box(
            modifier = modifier.height(20.dp)
        ) {

        }
        Text(text = "Browse for more", color = BrownDeep, modifier = modifier.clickable {



            navController.popBackStack("${ navController.graph.startDestinationRoute}", inclusive = false)


        })
    }
}
}

