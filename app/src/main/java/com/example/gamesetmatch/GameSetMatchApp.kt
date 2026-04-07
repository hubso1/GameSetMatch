package com.example.gamesetmatch

import android.app.Application
import androidx.room.Room
import com.example.gamesetmatch.data.AppDatabase
import com.example.gamesetmatch.data.MeczRepository

class GameSetMatchApp : Application() {
    val database by lazy { Room.databaseBuilder(this, AppDatabase::class.java, "tennis_db")
        .fallbackToDestructiveMigration()
        .build() }
    val repository by lazy { MeczRepository(database.meczDao()) }
}