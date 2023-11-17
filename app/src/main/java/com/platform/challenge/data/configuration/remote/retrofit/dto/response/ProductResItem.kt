package com.platform.challenge.data.configuration.remote.retrofit.dto.response

import com.platform.domain.models.Product

data class ProductResItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

fun ProductResItem.toProduct() = Product(id, title, price, image)
