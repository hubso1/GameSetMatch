package com.example.gamesetmatch.usr.sprzet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

//Ui dla ekranu Sprzęt
@Composable
fun SprzetScreen(viewModel: SprzetViewModel = viewModel()) {
    val rakieta = viewModel.rakieta

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(rakieta)
    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    SprzetScreen()
}