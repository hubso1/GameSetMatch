package com.example.gamesetmatch.usr.sprzet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.example.gamesetmatch.data.sprzet.SprzetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel dla ekranu sprzęt
@HiltViewModel
class SprzetViewModel @Inject constructor(
    private val sprzetRepository: SprzetRepository
) : ViewModel() {
    var rakieta by mutableStateOf("")
        private set
    var buty by mutableStateOf("")
        private set
    var torba by mutableStateOf("")
        private set

    var rakietaUri by mutableStateOf<String?>(null)
        private set
    var butyUri by mutableStateOf<String?>(null)
        private set
    var torbaUri by mutableStateOf<String?>(null)
        private set

    init {
        viewModelScope.launch {
            sprzetRepository.sprzet.collect { SprzetEntity ->
                rakieta = SprzetEntity?.rakieta ?: ""
                buty = SprzetEntity?.buty ?: ""
                torba = SprzetEntity?.torba ?: ""

                rakietaUri = SprzetEntity?.rakietaUri
                butyUri = SprzetEntity?.butyUri
                torbaUri = SprzetEntity?.torbaUri
            }
        }
    }
}