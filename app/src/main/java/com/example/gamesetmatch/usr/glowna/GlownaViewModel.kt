package com.example.gamesetmatch.usr.glowna

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesetmatch.data.MeczEntity
import com.example.gamesetmatch.data.MeczRepository
import com.example.gamesetmatch.data.sprzet.SprzetEntity
import com.example.gamesetmatch.data.sprzet.SprzetRepository
import com.example.gamesetmatch.data.user.UserEntity
import com.example.gamesetmatch.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

//ViewModel dla ekranu Główna
@HiltViewModel
class GlownaViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val meczRepository: MeczRepository,
    private val sprzetRepository: SprzetRepository
) : ViewModel() {

    var name by mutableStateOf("")
        private set
    var match by mutableStateOf<MeczEntity?>(null)
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
            userRepository.user.collect { UserEntity ->
                name = UserEntity?.user ?:""
            }

        }
        viewModelScope.launch {
            meczRepository.lastMatch.collect { MatchEntity ->
                match = MatchEntity
            }
        }
        viewModelScope.launch {
            sprzetRepository.sprzet.collect { SprzetEntity ->
                rakieta = SprzetEntity?.rakieta ?: ""
                buty = SprzetEntity?.buty ?: ""
                torba = SprzetEntity?.torba ?: ""
            }
        }
        viewModelScope.launch {
            sprzetRepository.sprzet.collect { entity ->
                rakietaUri = entity?.rakietaUri
                butyUri = entity?.butyUri
                torbaUri = entity?.torbaUri
            }
        }

    }
    fun nameChange(new_name: String){
        name = new_name
    }

    fun rakietaChange(new_rakieta: String){
        rakieta = new_rakieta
    }

    fun butyChange(new_buty: String){
        buty = new_buty
    }

    fun torbaChange(new_torba: String){
        torba = new_torba
    }
    fun updateRakietaUri(uri: String?) { rakietaUri = uri }
    fun updateButyUri(uri: String?) { butyUri = uri }
    fun updateTorbaUri(uri: String?) { torbaUri = uri }

    fun nameSave(){
        viewModelScope.launch {
            userRepository.saveUser(
                UserEntity(
                    id = 0,
                    user = name
                )
            )
        }
        viewModelScope.launch {
            sprzetRepository.saveSprzet(
                SprzetEntity(
                    id = 0,
                    rakieta = rakieta,
                    buty = buty,
                    torba = torba,
                    rakietaUri = rakietaUri,
                    butyUri = butyUri,
                    torbaUri = torbaUri
                )
            )
        }
    }

    val hi = "Cześć,"
    val kort = "Gotowy na kort?"
    val trening = "Rozpocznij\nTrening"

    val ostatni = "Ostatni mecz"


}
