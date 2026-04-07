package com.example.gamesetmatch.usr.mecze

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DodajMeczScreen(
    onNavigateBack: () -> Unit,
    viewModel: MeczeViewModel // Przekazujemy ViewModel bezpośrednio
) {
    val context = LocalContext.current
    var przeciwnik by remember { mutableStateOf("") }
    var dataMeczu by remember { mutableStateOf("") }
    var wynik by remember { mutableStateOf("") }
    var czyWygrany by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("DODAJ WYNIK") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Wstecz")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("PRZECIWNIK")
            OutlinedTextField(value = przeciwnik, onValueChange = { przeciwnik = it }, modifier = Modifier.fillMaxWidth())

            Text("DATA MECZU")
            OutlinedTextField(value = dataMeczu, onValueChange = { dataMeczu = it }, modifier = Modifier.fillMaxWidth(), placeholder = { Text("np. 12.03.2026") })

            Text("WYNIK W SETACH")
            OutlinedTextField(value = wynik, onValueChange = { wynik = it }, modifier = Modifier.fillMaxWidth(), placeholder = { Text("np. 6:4, 7:5") })

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("CZY WYGRAŁEŚ?")
                Switch(
                    checked = czyWygrany,
                    onCheckedChange = { czyWygrany = it },
                    colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFFC5FF2D))
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    viewModel.addMatchWithValidation(
                        przeciwnik, wynik, dataMeczu, czyWygrany,
                        onError = { error -> Toast.makeText(context, error, Toast.LENGTH_SHORT).show() },
                        onSuccess = { onNavigateBack() }
                    )
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC5FF2D))
            ) {
                Text("ZAPISZ WYNIK", color = Color.Black)
            }
        }
    }
}