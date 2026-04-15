package com.example.gamesetmatch.usr.glowna

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowCircleLeft
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetGlownyScreen(viewModel: GlownaViewModel,
    onNavigateBack: () -> Unit,

) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color(0xFFEBEBEB))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),

                verticalAlignment = Alignment.CenterVertically,

                ) {
                IconButton(
                    onClick = onNavigateBack,
                    Modifier.size(45.dp)
                ) {
                    Icon(
                        Icons.Outlined.ArrowCircleLeft,
                        contentDescription = null,
                        Modifier.size(45.dp)
                    )
                }
                Text("Ustawienia",fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 30.dp))
            }

        }
        Column( modifier = Modifier.padding(16.dp)
            .fillMaxSize()
        ) {
            Text("Użytkownik", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            TextField(
                value = viewModel.name,
                onValueChange = {text ->
                    viewModel.nameChange(text)
                },
                label = { Text("Nazwa") },
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(Modifier.height(20.dp))
            Text("Sprzęt", fontSize = 16.sp, fontWeight = FontWeight.Bold)

            TextField(state = rememberTextFieldState(initialText = "Hello"),
                label = { Text("Rakieta") },
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            )
            TextField(state = rememberTextFieldState(initialText = "Hello"),
                label = { Text("Buty") },
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            )
            TextField(state = rememberTextFieldState(initialText = "Hello"),
                label = { Text("Torba") },
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(Modifier.height(30.dp))
            Row(
                modifier = Modifier.background(color = Color(0xFFCBFF5B), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable(onClick = {
                        viewModel.nameSave()
                    }),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,


                ) {


                Icon(
                    Icons.Outlined.Save,
                    contentDescription = null,
                    Modifier.size(45.dp)
                )

                Text("ZAPISZ", fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 30.dp))
            }

    }
    }



}

