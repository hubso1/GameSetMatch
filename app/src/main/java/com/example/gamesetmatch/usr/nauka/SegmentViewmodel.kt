package com.example.gamesetmatch.usr.nauka

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gamesetmatch.R

class SegmentViewmodel: ViewModel() {
    var segment by mutableStateOf(SegmetType.Forehand)
        private set

    fun updateSegment(segset: SegmetType){
        segment = segset
    }
    var vid by mutableStateOf(true)

    val listforehand = listOf(
        R.drawable.f1,
        R.drawable.f2,
        R.drawable.f3,
        R.drawable.f4,
    )

    val listbackhand = listOf(
        R.drawable.b1,
        R.drawable.b2,
        R.drawable.b3,
        R.drawable.b4,
    )

    val listservis = listOf(
        R.drawable.s1,
        R.drawable.s2,
        R.drawable.s3,
        R.drawable.s4,
    )

}

enum class SegmetType{
    Forehand, Backhand, Serwis
}