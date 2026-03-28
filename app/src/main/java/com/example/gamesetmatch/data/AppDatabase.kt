package com.example.gamesetmatch.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MeczEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meczDao(): MeczDao
}