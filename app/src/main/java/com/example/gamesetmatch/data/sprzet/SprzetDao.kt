package com.example.gamesetmatch.data.sprzet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gamesetmatch.data.user.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SprzetDao{

    @Query("Select * From sprzet where id = 0")
    fun getSprzet(): Flow<SprzetEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSprzet(sprzet: SprzetEntity)
}