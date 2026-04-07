package com.example.gamesetmatch.usr.mecze

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gamesetmatch.data.MeczEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeczeScreen(
    onNavigateToAdd: () -> Unit, // Parametr dla AppNavHost
    viewModel: MeczeViewModel    // Parametr dla AppNavHost
) {
    // Tutaj pobieramy dane z bazy danych przez ViewModel
    val matches by viewModel.allMatches.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("MOJE MECZE", style = MaterialTheme.typography.headlineMedium) },
                actions = {
                    // Przycisk plusa przenoszący do DodajMeczScreen
                    IconButton(onClick = onNavigateToAdd) {
                        Icon(Icons.Default.AddCircle, "Dodaj", modifier = Modifier.size(32.dp))
                    }
                }
            )
        }
    ) { padding ->
        // Wywołujemy listę i przekazujemy jej padding z paska górnego
        MeczeListContent(
            matches = matches,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun MeczeListContent(
    matches: List<MeczEntity>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(matches) { match ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
                ) {
                    Box(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                        Column {
                            Text(
                                text = match.data,
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodySmall
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    text = "VS ${match.przeciwnik.uppercase()}",
                                    color = Color.White
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Text(
                                    text = match.wynik,
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }

                        // Kropka zwycięstwa po prawej stronie
                        if (match.czyWygrany) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(Color(0xFFC5FF2D), CircleShape)
                                    .align(Alignment.CenterEnd)
                                    .padding(end = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}