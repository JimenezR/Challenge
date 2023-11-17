package com.platform.domain.usecase

import com.platform.domain.models.Product
import com.platform.domain.repositories.ProductRepository

class GetProductUseCase(
    private val productsRepository: ProductRepository
) {

    suspend operator fun invoke(): List<Product> {
        TODO()
    }


}