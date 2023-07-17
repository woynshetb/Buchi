package com.example.buchi.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.buchi.R
import com.example.buchi.navigation.Screens
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownLight
import com.example.buchi.ui.theme.BrownWarm


@Composable
fun SpashPage(modifier: Modifier=Modifier,navController: NavController){
    var title:String ="Over\n200,000 \nStray \nDOGS \non Addis Ababa \nStreets in \n2020!"
    Scaffold(
        modifier = modifier,
 backgroundColor = BrownLight
        ) { padding ->  Column(
        modifier = modifier.padding(),

        verticalArrangement = Arrangement.SpaceBetween


    ) {



        Column(modifier.weight(3f)) {
            Box(

            ) {


                Image(
                    painter = painterResource(id = R.drawable.splash_dog),
                    contentDescription = "Splash Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier.fillMaxHeight().fillMaxWidth()
                )


                Text(text = title, fontSize = 40.sp, fontWeight = FontWeight.W900, color = BrownWarm,modifier = modifier.padding(20.dp)  )
            }

        }



Column(modifier.weight(3f)) {
    Column(
        modifier = modifier.padding(
            start = 20.dp, end = 90.dp, top = 36.dp, bottom = 56.dp
        )
    ) {



        Text(text = "Be part of the Solution", fontSize = 20.sp, fontWeight = FontWeight.W900, color = Color.Black)
        Box(
            modifier = modifier.height(20.dp)
        )
        Text(

            text = "Adopt a Stray pet to decrease the number of stray pets on the street for the safety of every one.",
            fontSize = 16.sp,
            textAlign = TextAlign.Left,
            color = Color.Black



        )
        Box(
            modifier = modifier.height(10.dp)
        )

        Text(text = "Start your Journey of finding your companion now using Buchi app",
            fontSize = 16.sp,
            textAlign = TextAlign.Left,
            color = Color.Black)
    }




    IconButton(
        modifier = modifier.align(alignment = Alignment.CenterHorizontally),
        onClick = {
            navController.navigate(Screens.MAIN.route)
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
}



    }
    }
}