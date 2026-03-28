package com.example.gamesetmatch.data

import kotlinx.coroutines.flow.Flow

class MeczRepository(private val meczDao: MeczDao) {
    val allMatches: Flow<List<MeczEntity>> = meczDao.getAllMatches()

    suspend fun addMatch(mecz: MeczEntity) {
        meczDao.insertMatch(mecz)
    }
}