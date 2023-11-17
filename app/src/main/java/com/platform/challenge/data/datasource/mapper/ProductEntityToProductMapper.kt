package com.platform.challenge.data.datasource.mapper

import com.platform.data.core.Mapper
import com.platform.challenge.data.configuration.local.room.entities.ProductEntity
import com.platform.data.models.Product
import javax.inject.Inject

class ProductEntityToProductMapper @Inject constructor() :
    Mapper<List<ProductEntity>, List<Product>> {

    override fun map(input: List<ProductEntity>): List<Product> {
        return input.map {
            Product(
                id = it.id,
                title = it.title,
                price = it.price,
                image = it.image
            )
        }
    }


}