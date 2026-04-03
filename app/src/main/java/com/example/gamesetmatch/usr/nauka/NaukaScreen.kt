package com.example.gamesetmatch.usr.nauka

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowCircleRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gamesetmatch.usr.nav.NavItem

//Ui dla ekranu Nauka
@Composable
fun NaukaScreen(
    viewModel: NaukaViewModel = viewModel(),
    navController: NavHostController
) {
    val nauka = viewModel.nauka
    val first = viewModel.first
    val second = viewModel.second
    val third = viewModel.third
    val modifier = Modifier.fillMaxWidth()
        .background(color = Color(0xFF1E1E1E), shape = RoundedCornerShape(16.dp))
        .padding(16.dp)
        .padding(top = 70.dp)

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)


    ){
        Text(nauka, fontSize = 30.sp, fontWeight = FontWeight.Bold )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(first,fontSize = 30.sp,color = Color(0xFFFFFFFF))
            IconButton(
                onClick = { navController.navigate(NavItem.Glowna.route) },
                modifier = Modifier.size(50.dp)

            ) {
                Icon(
                    Icons.Outlined.ArrowCircleRight,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = Color(0xFFCBFF5B)


                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(second,fontSize = 30.sp,color = Color(0xFFFFFFFF))
            IconButton(
                onClick = { navController.navigate(NavItem.Glowna.route) },
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    Icons.Outlined.ArrowCircleRight,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = Color(0xFFCBFF5B)


                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(third,fontSize = 30.sp,color = Color(0xFFFFFFFF))
            IconButton(
                onClick = { navController.navigate(NavItem.Glowna.route) },
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    Icons.Outlined.ArrowCircleRight,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = Color(0xFFCBFF5B)


                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    val navController = rememberNavController()
    NaukaScreen(navController = navController)
}

