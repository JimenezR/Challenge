package com.platform.data.product.datasoruce

import com.platform.data.models.Product
import com.platform.domain.core.Result

interface ProductLocalDataSource {

    suspend fun insertProducts(products: List<Product>): Result<Unit>

}