package com.platform.data.product

import com.platform.data.product.datasoruce.ProductLocalDataSource
import com.platform.data.product.datasoruce.ProductRemoteDataSource
import com.platform.data.product.mapper.ProductDataToProductDomainMapper
import com.platform.data.product.mapper.ProductDomainToProductDataMapper
import com.platform.domain.models.Product
import com.platform.domain.repositories.ProductRepository
import com.platform.domain.core.Result

class ProductRepositoryImp constructor(
    private val productLocalDataSource: ProductLocalDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource
): ProductRepository {

    override suspend fun setProducts(products: List<Product>): Result<Unit> {
        return try {
            productLocalDataSource.insertProducts(ProductDomainToProductDataMapper().map(products))
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getProducts(): Result<List<Product>> {
        return productRemoteDataSource.getProducts()
    }

    override suspend fun getProductsDB(): Result<List<Product>> {
        return try {
         Result.Success(productLocalDataSource.getProductsDB().let { ProductDataToProductDomainMapper().map(it) })
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}

