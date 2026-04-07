package com.example.gamesetmatch.usr.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamesetmatch.GameSetMatchApp
import com.example.gamesetmatch.usr.glowna.GlownyScreen
import com.example.gamesetmatch.usr.nauka.NaukaScreen
import com.example.gamesetmatch.usr.mecze.MeczeScreen
import com.example.gamesetmatch.usr.mecze.MeczeViewModel
import com.example.gamesetmatch.usr.mecze.DodajMeczScreen
import com.example.gamesetmatch.usr.sprzet.SprzetScreen
import com.example.gamesetmatch.usr.zasady.ZasadyScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    // Tworzymy ViewModel raz, aby współdzielić go między ekranami
    val meczeViewModel: MeczeViewModel = viewModel(
        factory = MeczeViewModel.Factory(
            (LocalContext.current.applicationContext as GameSetMatchApp).repository
        )
    )

    NavHost(
        navController = navController,
        startDestination = NavItem.Glowna.route
    ) {
        composable(NavItem.Glowna.route) { GlownyScreen(navController = navController) }
        composable(NavItem.Nauka.route) { NaukaScreen(navController = navController)}

        composable(NavItem.Mecze.route) {
            MeczeScreen(
                onNavigateToAdd = { navController.navigate("dodaj_mecz") },
                viewModel = meczeViewModel
            )
        }

        composable("dodaj_mecz") {
            DodajMeczScreen(
                onNavigateBack = { navController.popBackStack() },
                viewModel = meczeViewModel
            )
        }

        composable(NavItem.Sprzet.route) { SprzetScreen() }
        composable(NavItem.Zasady.route) { ZasadyScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun Compose_test(){
    AppNavHost(rememberNavController())
}