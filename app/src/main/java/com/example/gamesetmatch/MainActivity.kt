package com.example.gamesetmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gamesetmatch.usr.nav.AppNavHost
import com.example.gamesetmatch.usr.nav.BottomNavBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ustawienie contorlera który umożliwia nawigację
            val navController = rememberNavController()

            Scaffold(
                // Dolny panel nawigacyjny
                bottomBar = { BottomNavBar(navController) }
            ) { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    AppNavHost(navController)
                }
            }
        }
    }
}
