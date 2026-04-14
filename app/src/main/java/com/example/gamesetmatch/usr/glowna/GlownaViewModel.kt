package com.example.gamesetmatch.usr.glowna

import androidx.lifecycle.ViewModel
import com.example.gamesetmatch.data.sprzet.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

//ViewModel dla ekranu Główna
@HiltViewModel
class GlownaViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val user = "USER"

    val hi = "Cześć,\n"
    val kort = "Gotowy na kort?"
    val trening = "Rozpocznij\nTrening"

    val ostatni = "Ostatni mecz"


}
