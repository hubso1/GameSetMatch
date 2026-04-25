package com.example.gamesetmatch.usr.zasady

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamesetmatch.R


//Ui dla ekranu Zasady
@Composable
fun ZasadyScreen (viewModel: ZasadyViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)


    ) {

        ListItem(
            headlineContent = {
                Text(
                    text = stringResource(R.string.zasada),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },

            colors = ListItemDefaults.colors(
                containerColor = Color.Transparent,
                headlineColor = MaterialTheme.colorScheme.scrim,
            )
        )
    }
}
@Preview(showBackground = true )
@Composable
fun Compose_test(){
    ZasadyScreen()
}