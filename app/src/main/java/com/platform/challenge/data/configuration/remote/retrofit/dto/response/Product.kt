package com.platform.challenge.data.configuration.remote.retrofit.dto.response

import com.platform.challenge.ui.model.ProductUI
import com.platform.domain.models.Product

fun Product.toProductUI() = ProductUI(title.toString(), price?:0.0, image.toString())