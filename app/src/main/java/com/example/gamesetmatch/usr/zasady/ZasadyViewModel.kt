package com.example.gamesetmatch.usr.zasady

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//viewModel dla ekranu zasad
@HiltViewModel()
class ZasadyViewModel @Inject constructor() : ViewModel() {
    val zasada = "zasada"
}