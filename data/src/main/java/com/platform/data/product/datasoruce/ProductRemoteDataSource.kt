package com.platform.data.product.datasoruce

import com.platform.domain.core.Result
import com.platform.domain.models.Product
interface ProductRemoteDataSource {

    suspend fun getProducts(): Result<List<Product>>

}