package com.example.gamesetmatch.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gamesetmatch.data.sprzet.UserDao
import com.example.gamesetmatch.data.sprzet.UserEntity

@Database(entities = [MeczEntity::class, UserEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meczDao(): MeczDao
    abstract fun userDao(): UserDao
}