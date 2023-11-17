package com.platform.data.product.mapper

import com.platform.data.core.Mapper
import com.platform.domain.models.Product

class ProductDomainToProductDataMapper: Mapper<List<Product>, List<com.platform.data.models.Product>> {
    override fun map(input: List<Product>): List<com.platform.data.models.Product> {
        return input.map {
            com.platform.data.models.Product(
                id = it.id,
                title = it.title,
                price = it.price,
                image = it.image,
            )
        }
    }
}