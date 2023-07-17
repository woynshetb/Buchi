package com.example.buchi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buchi.R
import com.example.buchi.ui.theme.BrownDeep
import com.example.buchi.ui.theme.BrownPeru


@Composable
fun CustomAppBar(modifier: Modifier = Modifier){
    Row( modifier = Modifier.fillMaxWidth(),


        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Box(
            modifier = modifier.width(20.dp)
        ) {

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,

            ) {
            // logo here


            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(30.dp)
                    .width(30.dp)


            )

            Box(
                modifier = modifier.width(10.dp)
            ) {

            }

            Text(
                "Buchi",
                fontWeight = FontWeight.W900,
                color = BrownPeru,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp,




                )
        }

        Icon(
            Icons.Rounded.Menu,
            modifier = modifier
                .size(20.dp).padding(
                    end = 5.dp
                ),
            tint = BrownDeep,

            contentDescription = "menu",


            )
    }
}