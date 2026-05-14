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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamesetmatch.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DodajMeczScreen(
    onNavigateBack: () -> Unit,
    viewModel: MeczeViewModel,
    name: String
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
                    Text(stringResource(R.string.ok))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(stringResource(R.string.anuluj))
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ListItem(
            colors = ListItemDefaults.colors(Color.Transparent),
            headlineContent = {
                Text(
                    text = name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            leadingContent = {
                IconButton(
                    onClick =
                        onNavigateBack
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )


        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(stringResource(R.string.przeciwnik))
            OutlinedTextField(
                value = przeciwnik,
                onValueChange = { przeciwnik = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.imi_przeciwnika)) }
            )

            Text(stringResource(R.string.data_meczu))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = dataMeczu,
                    onValueChange = { },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(stringResource(R.string.wybierz_dat)) },
                    readOnly = true, // Użytkownik nie może pisać z klawiatury
                    enabled = true
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clickable { showDatePicker = true }
                )
            }

            Text(stringResource(R.string.wynik_w_setach))
            OutlinedTextField(
                value = wynik,
                onValueChange = { wynik = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.np_6_4_7_5)) }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(stringResource(R.string.czy_wygra_e))
                Switch(
                    checked = czyWygrany,
                    onCheckedChange = { czyWygrany = it },
                    colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.secondary)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    viewModel.addMatchWithValidation(
                        przeciwnik, wynik, dataMeczu, czyWygrany,
                        onError = { error ->
                            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                        },
                        onSuccess = { onNavigateBack() }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text(stringResource(R.string.zapisz_wynik), color = MaterialTheme.colorScheme.scrim)
            }
        }
    }
    }
