package com.example.gamesetmatch.usr.glowna

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GlownyScreen(viewModel: GlownaViewModel = viewModel()) {
    val glowna = viewModel.glowna

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(glowna)
    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    GlownyScreen()
}