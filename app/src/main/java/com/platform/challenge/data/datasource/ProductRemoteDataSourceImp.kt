package com.platform.challenge.data.datasource

import com.platform.challenge.data.configuration.remote.retrofit.ApiService
import com.platform.challenge.data.configuration.remote.retrofit.dto.response.toProduct
import com.platform.data.product.datasoruce.ProductRemoteDataSource
import com.platform.domain.core.Result
import com.platform.domain.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRemoteDataSourceImp(
    private val apiService: ApiService
): ProductRemoteDataSource {
    override suspend fun getProducts(): Result<List<Product>> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getProductsAsync()
            if (response.isSuccessful) {
                Result.Success(response.body()?.map { it.toProduct() } ?: emptyList())
            }
            else {
                Result.Error(Exception(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }


}