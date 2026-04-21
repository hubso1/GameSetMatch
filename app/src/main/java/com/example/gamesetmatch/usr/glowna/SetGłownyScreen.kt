package com.example.gamesetmatch.usr.glowna

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetGlownyScreen(
    navController: NavController,
    viewModel: GlownaViewModel
) {
    val context = LocalContext.current

    val rakietaPicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri?.let {
            context.contentResolver.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            viewModel.updateRakietaUri(it.toString())
        }
    }

    val butyPicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri?.let {
            context.contentResolver.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            viewModel.updateButyUri(it.toString())
        }
    }

    val torbaPicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri?.let {
            context.contentResolver.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            viewModel.updateTorbaUri(it.toString())
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("USTAWIENIA PROFILU") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Wstecz")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Ekran będzie przewijany
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Column {
                Text("Dane gracza", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = viewModel.name ?: "",
                    onValueChange = { viewModel.nameChange(it) },
                    label = { Text("Twoja nazwa / Imię") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            HorizontalDivider()

            Text("Twój sprzęt", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Gray)

            //RAKIETA
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = viewModel.rakieta ?: "",
                    onValueChange = { viewModel.rakietaChange(it) },
                    label = { Text("Model rakiety") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = { rakietaPicker.launch(arrayOf("image/*")) },
                    modifier = Modifier.size(56.dp).background(Color.DarkGray, CircleShape)
                ) {
                    if (viewModel.rakietaUri != null) {
                        AsyncImage(
                            model = viewModel.rakietaUri,
                            contentDescription = "Rakieta",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize().clip(CircleShape)
                        )
                    } else {
                        Icon(Icons.Default.ImageSearch, contentDescription = "Wybierz", tint = Color.White)
                    }
                }
            }

            // BUTY
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = viewModel.buty ?: "",
                    onValueChange = { viewModel.butyChange(it) },
                    label = { Text("Buty") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = { butyPicker.launch(arrayOf("image/*")) },
                    modifier = Modifier.size(56.dp).background(Color.DarkGray, CircleShape)
                ) {
                    if (viewModel.butyUri != null) {
                        AsyncImage(
                            model = viewModel.butyUri,
                            contentDescription = "Buty",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize().clip(CircleShape)
                        )
                    } else {
                        Icon(Icons.Default.ImageSearch, contentDescription = "Wybierz", tint = Color.White)
                    }
                }
            }

            // TORBA
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = viewModel.torba ?: "",
                    onValueChange = { viewModel.torbaChange(it) },
                    label = { Text("Torba") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = { torbaPicker.launch(arrayOf("image/*")) },
                    modifier = Modifier.size(56.dp).background(Color.DarkGray, CircleShape)
                ) {
                    if (viewModel.torbaUri != null) {
                        AsyncImage(
                            model = viewModel.torbaUri,
                            contentDescription = "Torba",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize().clip(CircleShape)
                        )
                    } else {
                        Icon(Icons.Default.ImageSearch, contentDescription = "Wybierz", tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    viewModel.nameSave()
                    Toast.makeText(context, "Zapisano zmiany!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC5FF2D))
            ) {
                Text("ZAPISZ PROFIL", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}