package com.example.gamesetmatch.usr.mecze

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamesetmatch.GameSetMatchApp
import com.example.gamesetmatch.data.MeczEntity

@Composable
fun MeczeScreen(
    viewModel: MeczeViewModel = viewModel(
        factory = MeczeViewModel.Factory((LocalContext.current.applicationContext as GameSetMatchApp).repository)
    )
) {
    // Obserwujemy listę meczów z bazy danych
    val matches by viewModel.allMatches.collectAsState(initial = emptyList())

    MeczeContent(
        matches = matches,
        onAddTestMatch = { viewModel.addTestMatch() }
    )
}

@Composable
fun MeczeContent(
    matches: List<MeczEntity>,
    onAddTestMatch: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Twoje Mecze", style = MaterialTheme.typography.headlineMedium)
        
        Spacer(modifier = Modifier.height(16.dp))

        // Przycisk do testowania dodawania danych
        Button(onClick = onAddTestMatch) {
            Text("Dodaj testowy mecz")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista meczów
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(matches) { match ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = "Przeciwnik: ${match.przeciwnik}", style = MaterialTheme.typography.titleMedium)
                        Text(text = "Wynik: ${match.wynik}")
                        Text(text = "Data: ${match.data}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeczeScreenPreview() {
    val dummyMatches = listOf(
        MeczEntity(1, "Roger Federer", "6:4, 7:6", "12.10.2023"),
        MeczEntity(2, "Rafael Nadal", "2:6, 3:6", "15.10.2023")
    )
    MeczeContent(matches = dummyMatches, onAddTestMatch = {})
}
