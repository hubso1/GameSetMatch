package com.example.gamesetmatch.usr.nauka

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

//Ui dla ekranu Nauka
@Composable
fun NaukaScreen(viewModel: NaukaViewModel = viewModel()) {
    val nauka = viewModel.nauka

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(nauka)
    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    NaukaScreen()
}
