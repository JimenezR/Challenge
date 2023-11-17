package com.platform.challenge.data.datasource

import com.platform.challenge.data.configuration.local.room.dao.ProductDao
import com.platform.challenge.data.datasource.mapper.ProductEntityToProductMapper
import com.platform.challenge.data.datasource.mapper.ProductToProductEntityMapper
import com.platform.data.models.Product
import com.platform.data.product.datasoruce.ProductLocalDataSource
import com.platform.domain.core.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductLocalDataSourceImp (
    private val productDao: ProductDao,
    private val productEntityToProductMapper: ProductEntityToProductMapper,
    private val productToProductEntityMapper: ProductToProductEntityMapper,
): ProductLocalDataSource {

    override suspend fun insertProducts(products: List<Product>) = withContext(Dispatchers.IO) {
        try {
            productDao.insert(productToProductEntityMapper.map(products)).let {
                Result.Success(Unit)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getProductsDB(): Result<List<Product>> {
        return try {
            Result.Success(productEntityToProductMapper.map(productDao.getProducts()!!))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}