package com.platform.challenge.data.configuration.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.platform.challenge.data.configuration.local.room.dao.ProductDao
import com.platform.challenge.data.configuration.local.room.entities.ProductEntity


@Database(
    entities = [ProductEntity::class],
    version = ChallengeDataBase.VERSION,
    exportSchema = false
)
abstract class ChallengeDataBase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        const val VERSION = 1
    }

}