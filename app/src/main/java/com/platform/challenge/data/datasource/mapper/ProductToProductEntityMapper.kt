package com.platform.challenge.data.datasource.mapper

import com.platform.data.core.Mapper
import com.platform.challenge.data.configuration.local.room.entities.ProductEntity
import com.platform.data.models.Product
import javax.inject.Inject


class ProductToProductEntityMapper @Inject constructor() :
    Mapper<List<Product>, List<ProductEntity>> {

    override fun map(input: List<Product>): List<ProductEntity> {

        return input.map {
            ProductEntity(
                id = it.id,
                title = it.title,
                price = it.price,
                image = it.image
            )
        }

    }

}