package com.example.gamesetmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gamesetmatch.ui.theme.AppTheme
import com.example.gamesetmatch.usr.nav.AppNavHost
import com.example.gamesetmatch.usr.nav.BottomNavBar
import com.example.gamesetmatch.usr.nav.NavItem



import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // ustawienie contorlera który umożliwia nawigację
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val current_route = navBackStackEntry?.destination?.route

                Scaffold(

                    // Dolny panel nawigacyjn
                    bottomBar = {
                        if (current_route in listOf(
                                NavItem.Glowna.route,
                                NavItem.Nauka.route,
                                NavItem.Mecze.route,
                                NavItem.Sprzet.route,
                                NavItem.Zasady.route)){
                            BottomNavBar(navController) }
                    }
                ) { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        AppNavHost(navController)
                    }
                }
            }
        }
    }
}
