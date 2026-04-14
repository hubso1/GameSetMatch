package com.example.gamesetmatch.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MeczRepository @Inject constructor(private val meczDao: MeczDao) {
    val allMatches: Flow<List<MeczEntity>> = meczDao.getAllMatches()

    suspend fun addMatch(mecz: MeczEntity) {
        meczDao.insertMatch(mecz)
    }
}