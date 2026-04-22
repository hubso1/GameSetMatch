package com.example.gamesetmatch.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MeczDao {
    @Query("SELECT * FROM mecze ORDER BY id DESC")
    fun getAllMatches(): Flow<List<MeczEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(mecz: MeczEntity)

    @Delete
    suspend fun deleteMatch(mecz: MeczEntity)

    @Query("SELECT * FROM mecze ORDER BY id DESC LIMIT 1")
    fun getLastMatch(): Flow<MeczEntity?>
}