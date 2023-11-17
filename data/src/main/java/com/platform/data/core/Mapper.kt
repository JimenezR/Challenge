package com.platform.data.core

interface Mapper<I, O> {
    fun map(input: I): O
}