package com.example.gamesetmatch.usr.glowna

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesetmatch.data.MeczEntity
import com.example.gamesetmatch.data.MeczRepository
import com.example.gamesetmatch.data.user.UserEntity
import com.example.gamesetmatch.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

//ViewModel dla ekranu Główna
@HiltViewModel
class GlownaViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val meczRepository: MeczRepository
) : ViewModel() {

    var name by mutableStateOf("")
        private set
    var match by mutableStateOf<MeczEntity?>(null)

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
    }
    fun nameChange(new_name: String){
        name = new_name
    }

    fun nameSave(){
        viewModelScope.launch {
            userRepository.saveUser(
                UserEntity(
                    id = 0,
                    user = name
                )
            )
        }
    }

    val hi = "Cześć,"
    val kort = "Gotowy na kort?"
    val trening = "Rozpocznij\nTrening"

    val ostatni = "Ostatni mecz"


}
