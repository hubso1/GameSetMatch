package com.example.gamesetmatch.data.sprzet

import com.example.gamesetmatch.data.user.UserDao
import com.example.gamesetmatch.data.user.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SprzetRepository @Inject constructor(private val dao: SprzetDao) {
    val sprzet: Flow<SprzetEntity?> = dao.getSprzet()

    suspend fun saveSprzet(sprzet: SprzetEntity){
        dao.saveSprzet(sprzet)
    }
}