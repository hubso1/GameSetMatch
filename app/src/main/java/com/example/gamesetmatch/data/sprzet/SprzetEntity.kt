package com.example.gamesetmatch.data.sprzet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sprzet")
data class SprzetEntity(
    @PrimaryKey val id: Int = 0,
    val rakieta: String = "",
    val buty: String = "",
    val torba: String = ""
)