package com.example.gamesetmatch.usr.mecze

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gamesetmatch.data.MeczEntity
import com.example.gamesetmatch.data.MeczRepository
import kotlinx.coroutines.launch

class MeczeViewModel(private val repository: MeczRepository) : ViewModel() {
    // Flow z listą wszystkich meczów
    val allMatches = repository.allMatches
    val mecz = "Mecze"

    // Funkcja do dodawania testowego meczu
    fun addTestMatch() {
        viewModelScope.launch {
            repository.addMatch(
                MeczEntity(
                    przeciwnik = "Przeciwnik ${System.currentTimeMillis() % 1000}",
                    wynik = "6:4, 6:2",
                    data = "28.03.2026"
                )
            )
        }
    }

    class Factory(private val repository: MeczRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MeczeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MeczeViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
