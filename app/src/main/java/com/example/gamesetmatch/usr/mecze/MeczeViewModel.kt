package com.example.gamesetmatch.usr.mecze

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesetmatch.data.MeczEntity
import com.example.gamesetmatch.data.MeczRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MeczeViewModel @Inject constructor(
    private val repository: MeczRepository
) : ViewModel() {


    val allMatches = repository.allMatches

    // Główna funkcja z logiką walidacji
    fun addMatchWithValidation(
        opponent: String,
        score: String,
        date: String,
        isWinner: Boolean,
        onError: (String) -> Unit,
        onSuccess: () -> Unit
    ) {
        // 1. Walidacja czy pola nie są puste
        if (opponent.isBlank() || score.isBlank() || date.isBlank()) {
            onError("Wszystkie pola muszą być wypełnione")
            return
        }

        // 2. Walidacja Daty (Format DD.MM.RRRR) # do poprawy
        val dateRegex = """\d{2}\.\d{2}\.\d{4}""".toRegex()
        if (!dateRegex.matches(date)) {
            onError("Data musi być w formacie DD.MM.RRRR")
            return
        }

        // 3. Walidacja Wyniku (Reguły tenisa)
        try {
            val sets = score.split(",").map { it.trim() }
            if (sets.size > 5) {
                onError("Maksymalnie 5 setów")
                return
            }

            for (set in sets) {
                val games = set.split(":")
                if (games.size != 2) {
                    onError("Użyj formatu Gemy:Gemy (np. 6:4)")
                    return
                }
                val g1 = games[0].toInt()
                val g2 = games[1].toInt()
                if (g1 > 7 || g2 > 7) {
                    onError("W secie max 7 gemów")
                    return
                }
            }
        } catch (e: Exception) {
            onError("Błąd w formacie wyniku")
            return
        }

        // Zapis do bazy
        viewModelScope.launch {
            repository.addMatch(
                MeczEntity(
                    przeciwnik = opponent,
                    wynik = score,
                    data = date,
                    czyWygrany = isWinner
                )
            )
            onSuccess()
        }
    }


}