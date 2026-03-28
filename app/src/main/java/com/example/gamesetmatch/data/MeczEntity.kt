package com.example.gamesetmatch.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mecze")
data class MeczEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val przeciwnik: String,
    val wynik: String,
    val data: String
)
