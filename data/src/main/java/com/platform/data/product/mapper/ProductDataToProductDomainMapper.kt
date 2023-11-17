package com.platform.data.product.mapper

import com.platform.data.core.Mapper
import com.platform.data.core.MapperProducts
import com.platform.domain.core.Result
import com.platform.domain.models.Product

class ProductDataToProductDomainMapper: MapperProducts<List<com.platform.data.models.Product>, List<Product>> {
    override fun map(input: Result<List<com.platform.data.models.Product>>): List<Product> {
        input.let {
            return when (input) {
                is Result.Success -> {
                    input.data.map {
                        Product(
                            id = it.id,
                            title = it.title,
                            price = it.price,
                            image = it.image
                        )
                    }
                }
                is Result.Error -> {
                    emptyList()
                }
            }
        }
    }
}