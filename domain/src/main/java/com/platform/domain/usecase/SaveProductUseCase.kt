package com.platform.domain.usecase

import com.platform.domain.models.Product
import com.platform.domain.repositories.ProductRepository

class SaveProductUseCase(
    private val productLocalRepository: ProductRepository
) {

    suspend operator fun invoke(products: List<Product>) {
        productLocalRepository.setProducts(products)
    }

}