package com.example.gamesetmatch.usr.sprzet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SprzetScreen(
    viewModel: SprzetViewModel
) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,) {


    ListItem(
        headlineContent = {
            Text(
                "Mój Sprzęt",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        },

        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent,
            headlineColor = MaterialTheme.colorScheme.scrim,
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // Karta 1: Rakieta
        SprzetCard(
            kategoria = "RAKIETA",
            nazwaSprzetu = viewModel.rakieta ?: "Brak danych",
            uri = viewModel.rakietaUri
        )

        // Karta 2: Buty
        SprzetCard(
            kategoria = "BUTY",
            nazwaSprzetu = viewModel.buty ?: "Brak danych",
            uri = viewModel.butyUri
        )

        // Karta 3: Torba
        SprzetCard(
            kategoria = "TORBA",
            nazwaSprzetu = viewModel.torba ?: "Brak danych",
            uri = viewModel.torbaUri
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

    }



@Composable
fun SprzetCard(kategoria: String, nazwaSprzetu: String, uri: String?) {
    Column(horizontalAlignment = Alignment.Start) {

        if (uri != null && uri.isNotBlank()) {
            AsyncImage(
                model = uri,
                contentDescription = "Zdjęcie $kategoria",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF2C2C2C))
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF2C2C2C)),
                contentAlignment = Alignment.Center
            ) {
                Text("Brak zdjęcia galerii", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = kategoria,
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = nazwaSprzetu.uppercase(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black
        )
    }
}