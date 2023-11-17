package com.platform.challenge.core

interface Mapper<I, O> {
    fun map(input: I): O
}