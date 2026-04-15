package com.example.gamesetmatch.di

import android.app.Application
import androidx.room.Room
import com.example.gamesetmatch.data.AppDatabase
import com.example.gamesetmatch.data.MeczDao
import com.example.gamesetmatch.data.user.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "tennis_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideMeczDao(db: AppDatabase): MeczDao = db.meczDao()

}