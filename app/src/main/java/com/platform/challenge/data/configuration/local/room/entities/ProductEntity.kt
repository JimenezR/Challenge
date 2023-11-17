package com.platform.challenge.data.configuration.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Int? = null,
    val title: String? = null,
    val price: Double? = null,
    val image: String? = null
)