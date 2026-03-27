package com.example.gamesetmatch.usr.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(val route: String, val label: String, val icon: ImageVector) {
    object Glowna : NavItem("glowna", "Główna", Icons.Default.Home)
    object Nauka : NavItem("nauka", "Nauka", Icons.Default.School)
    object Mecze : NavItem("mecze", "Mecze", Icons.AutoMirrored.Filled.Assignment)
    object Sprzet : NavItem("sprzet", "Sprzęt", Icons.Default.SportsTennis)
    object Zasady : NavItem("zasady", "Zasady", Icons.Default.WarningAmber)
}
