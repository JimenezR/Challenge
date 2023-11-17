package com.platform.domain.usecase

import com.platform.domain.models.Product
import com.platform.domain.repositories.ProductRepository
import com.platform.domain.core.Result

class ProductUseCase(
    private val productsRepository: ProductRepository
) {

    suspend operator fun invoke(): Result<List<Product>> = productsRepository.getProducts()

}