package com.example.gamesetmatch.usr.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamesetmatch.usr.glowna.GlownaViewModel
import com.example.gamesetmatch.usr.glowna.GlownyScreen
import com.example.gamesetmatch.usr.glowna.SetGlownyScreen
import com.example.gamesetmatch.usr.mecze.DodajMeczScreen
import com.example.gamesetmatch.usr.mecze.MeczeScreen
import com.example.gamesetmatch.usr.mecze.MeczeViewModel
import com.example.gamesetmatch.usr.nauka.NaukaScreen
import com.example.gamesetmatch.usr.sprzet.SprzetScreen
import com.example.gamesetmatch.usr.sprzet.SprzetViewModel
import com.example.gamesetmatch.usr.zasady.ZasadyScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    // Tworzymy ViewModel raz, aby współdzielić go między ekranami

    NavHost(
        navController = navController,
        startDestination = NavItem.Glowna.route
    ) {
        composable(NavItem.Glowna.route) {
            val vm: GlownaViewModel = hiltViewModel()
            GlownyScreen(
                viewModel = vm,
                onNavigateToNauka = { navController.navigate(NavItem.Nauka.route)},
                onNavigateToUStawienia = { navController.navigate(NavItem.Ustawienia.route)}
            )
        }
        composable(NavItem.Ustawienia.route ) {
            val vm: GlownaViewModel = hiltViewModel()
            SetGlownyScreen(
                navController = navController,
                viewModel = vm
            )
        }
        composable(NavItem.Nauka.route) { NaukaScreen(
            onNavigatetoForehand = { navController.navigate("sprzet")},
            onNavigatetoBackhand = { navController.navigate("sprzet")},
            onNavigatetoSerwis = {navController.navigate("sprzet")}
        )
        }

        composable(NavItem.Mecze.route) {
            val vm: MeczeViewModel = hiltViewModel()
            MeczeScreen(
                viewModel = vm,
                onNavigateToAdd = { navController.navigate("dodaj_mecz") },
            )
        }

        composable("dodaj_mecz") {
            val vm: MeczeViewModel = hiltViewModel()
            DodajMeczScreen(
                viewModel = vm,
                onNavigateBack = { navController.popBackStack() },
            )
        }

        composable(NavItem.Sprzet.route) {
            val vm : SprzetViewModel = hiltViewModel()
            SprzetScreen(
                viewModel = vm
            )
        }
        composable(NavItem.Zasady.route) { ZasadyScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun Compose_test(){
    AppNavHost(rememberNavController())
}