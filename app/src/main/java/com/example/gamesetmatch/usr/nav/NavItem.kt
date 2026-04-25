package com.example.gamesetmatch.usr.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings

sealed class NavItem(val route: String, val label: String, val icon: ImageVector) {
    object Glowna : NavItem("glowna", "Główna", Icons.Default.Home)
    object Nauka : NavItem("nauka", "Nauka", Icons.Default.School)
    object Mecze : NavItem("mecze", "Mecze", Icons.AutoMirrored.Filled.Assignment)
    object Sprzet : NavItem("sprzet", "Sprzęt", Icons.Default.SportsTennis)
    object Zasady : NavItem("zasady", "Zasady", Icons.Default.WarningAmber)

    object DodajMecz : NavItem("dodaj_mecz", "Dodaj", Icons.Default.Add)

    object Ustawienia : NavItem("ustawienia", "ustawienia", Icons.Default.Settings)
    object Forehand : NavItem("forehand", "Forehand", Icons.Default.School)
    object Backhand : NavItem("backhand", "Backhand", Icons.Default.School)
    object Serwis : NavItem("serwis", "Serwis", Icons.Default.School)
}
