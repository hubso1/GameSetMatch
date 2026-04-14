package com.example.gamesetmatch.usr.glowna

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
import androidx.compose.material.icons.filled.Settings
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
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun GlownyScreen(viewModel: GlownaViewModel,
                 onNavigateToMecze: () -> Unit,
                 onNavigateToUStawienia: () -> Unit
                 ) {

    val hi = viewModel.hi
    val kort = viewModel.kort
    val trening = viewModel.trening
    val ostatni = viewModel.ostatni


    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                verticalArrangement = Arrangement.Center
                )
            {
                Text(hi, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(kort, fontSize = 15.sp)
            }

            IconButton(
                onClick = onNavigateToUStawienia ,

                ) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = null,
                    Modifier.size(35.dp)
                )
                }


        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.background(color = Color(0xFFCBFF5B), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Text(trening, fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(5.dp))
            IconButton(
                onClick = onNavigateToMecze,
                Modifier.size(45.dp)
                ) {
                Icon(
                    Icons.Outlined.ArrowCircleRight,
                    contentDescription = null,
                    Modifier.size(45.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(ostatni, fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(5.dp))

    }
}


@Preview(showBackground = true )
@Composable
fun Compose_test(){
    val vm: GlownaViewModel = hiltViewModel()
    GlownyScreen(viewModel = vm,onNavigateToMecze = {},
        onNavigateToUStawienia = {})

}