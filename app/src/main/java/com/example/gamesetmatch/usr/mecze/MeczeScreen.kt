package com.example.gamesetmatch.usr.mecze

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamesetmatch.data.MeczEntity
import com.example.gamesetmatch.usr.nav.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeczeScreen(
    onNavigateToAdd: () -> Unit, // Parametr dla AppNavHost
    viewModel: MeczeViewModel    // Parametr dla AppNavHost
) {
    // Tutaj pobieramy dane z bazy danych przez ViewModel
    val matches by viewModel.allMatches.collectAsState(initial = emptyList())
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,) {

        ListItem(
            headlineContent = {
                Text(
                    "Moje Mecze",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },

            trailingContent = {
                IconButton(onClick = onNavigateToAdd) {
                    Icon(
                        NavItem.DodajMecz.icon,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
            },
            colors = ListItemDefaults.colors(
                containerColor = Color.Transparent,
                headlineColor = MaterialTheme.colorScheme.scrim,
                supportingColor = MaterialTheme.colorScheme.scrim,
                trailingIconColor = MaterialTheme.colorScheme.scrim
            )
        )
        MeczeListContent(
            matches = matches,
            modifier = Modifier.padding(16.dp)
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
            .fillMaxSize(),

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