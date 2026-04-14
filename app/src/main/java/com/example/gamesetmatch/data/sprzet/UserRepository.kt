package com.example.gamesetmatch.data.sprzet

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val dao: UserDao) {
    val user: Flow<UserEntity> = dao.getUser()

    suspend fun saveUser(user: UserEntity){
        dao.saveUser(user)
    }
}