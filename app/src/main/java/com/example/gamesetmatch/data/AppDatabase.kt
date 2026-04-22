package com.example.gamesetmatch.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gamesetmatch.data.sprzet.SprzetDao
import com.example.gamesetmatch.data.sprzet.SprzetEntity
import com.example.gamesetmatch.data.user.UserDao
import com.example.gamesetmatch.data.user.UserEntity

@Database(entities = [MeczEntity::class, UserEntity::class, SprzetEntity::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meczDao(): MeczDao
    abstract fun userDao(): UserDao
    abstract fun sprzetDao(): SprzetDao
}