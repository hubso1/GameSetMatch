package com.example.gamesetmatch.usr.mecze

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


//Ui dla ekranu sprzęt
@Composable
fun MeczeScreen(viewModel: MeczeViewModel = viewModel()) {
    val mecz = viewModel.mecz

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(mecz)
    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    MeczeScreen()
}