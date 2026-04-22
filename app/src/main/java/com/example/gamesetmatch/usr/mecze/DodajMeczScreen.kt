package com.example.gamesetmatch.usr.mecze

import android.widget.Toast
import androidx.compose.foundation.clickable
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppDodajMecze(onNavigateBack: () -> Unit){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "DODAJ WYNIK",
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {

            IconButton(onClick = onNavigateBack) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back")

            }
        }


    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DodajMeczScreen(
    onNavigateBack: () -> Unit,
    viewModel: MeczeViewModel
) {
    val context = LocalContext.current
    var przeciwnik by remember { mutableStateOf("") }
    var wynik by remember { mutableStateOf("") }
    var czyWygrany by remember { mutableStateOf(false) }

    // Logika kalendarza
    var dataMeczu by remember { mutableStateOf("") } 
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    fun formatMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return formatter.format(Date(millis))
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    val selectedDate = datePickerState.selectedDateMillis
                    if (selectedDate != null) {
                        dataMeczu = formatMillisToDate(selectedDate)
                    }
                    showDatePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Anuluj")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }


        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("PRZECIWNIK")
            OutlinedTextField(
                value = przeciwnik,
                onValueChange = { przeciwnik = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Imię przeciwnika") }
            )

            Text("DATA MECZU")
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = dataMeczu,
                    onValueChange = { },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Wybierz datę") },
                    readOnly = true, // Użytkownik nie może pisać z klawiatury
                    enabled = true
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clickable { showDatePicker = true }
                )
            }

            Text("WYNIK W SETACH")
            OutlinedTextField(
                value = wynik,
                onValueChange = { wynik = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("np. 6:4, 7:5") }
            )

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
