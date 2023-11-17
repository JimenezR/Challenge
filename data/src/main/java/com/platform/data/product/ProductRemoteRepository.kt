package com.platform.data.product

import com.platform.data.product.datasoruce.ProductRemoteDataSource

class ProductRemoteRepository constructor(private val productRemoteDataSource: ProductRemoteDataSource) {

    suspend fun getProducts() = productRemoteDataSource.getProducts()

}