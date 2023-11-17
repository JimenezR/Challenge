package com.platform.challenge.di

import android.app.Application
import androidx.room.Room
import com.platform.challenge.data.configuration.local.room.ChallengeDataBase
import com.platform.challenge.data.configuration.local.room.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    companion object {
        const val APPLICATION_DB_NAME = "challenge_db"
    }

    @Singleton
    @Provides
    fun provideChallengeDataBase(application: Application): ChallengeDataBase {
        return Room.databaseBuilder(
            application.applicationContext,
            ChallengeDataBase::class.java,
            APPLICATION_DB_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideProductDao(challengeDataBase: ChallengeDataBase): ProductDao {
        return challengeDataBase.productDao()
    }

}