package com.platform.domain.usecase

import com.platform.domain.core.Result
import com.platform.domain.models.Product
import com.platform.domain.repositories.ProductRepository

class GetProductUseCase(
    private val productsRepository: ProductRepository
) {

    suspend operator fun invoke(): Result<List<Product>> {
        return productsRepository.getProductsDB()
    }


}