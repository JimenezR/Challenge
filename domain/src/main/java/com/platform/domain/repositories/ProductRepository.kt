package com.platform.domain.repositories

import com.platform.domain.models.Product
import com.platform.domain.core.Result

interface ProductRepository {
    suspend fun setProducts(products: List<Product>): Result<Unit>

    suspend fun getProducts(): Result<List<Product>>

    suspend fun getProductsDB(): Result<List<Product>>

}