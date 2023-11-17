package com.platform.data.core

import com.platform.data.models.Product
import com.platform.domain.core.Result

interface MapperProducts<I, O> {
    fun map(input: Result<List<Product>>): O
}