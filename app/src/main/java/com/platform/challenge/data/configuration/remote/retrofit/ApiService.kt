package com.platform.challenge.data.configuration.remote.retrofit

import com.platform.challenge.data.configuration.remote.retrofit.dto.response.ProductRes
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProductsAsync(): Response<ProductRes>

}