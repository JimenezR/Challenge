/*
 * Copyright (c) 2023 DevCulture Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * DevCulture Inc. ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with DevCulture Inc.
 */

package com.platform.challenge.data.configuration.remote.retrofit.dto.response;

import com.google.gson.annotations.SerializedName
import com.platform.domain.models.Product

data class ProductResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("image")
    val image: String
)

fun ProductResponse.toProduct() = Product(id)
