package com.example.gamesetmatch.usr.sprzet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.util.TableInfo
import com.example.gamesetmatch.data.sprzet.SprzetRepository

//Ui dla ekranu Sprzęt
@Composable
fun SprzetScreen(
    viewModel: SprzetViewModel
                 ) {
    val rakieta = viewModel.rakieta

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(viewModel.rakieta)
            Text(viewModel.buty)
            Text(viewModel.torba)
        }

    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    val vm : SprzetViewModel = hiltViewModel()
    SprzetScreen(viewModel = vm)
}