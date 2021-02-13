package com.example.androidacademyfundamentals.model.mappers

interface Mapper<T, K> {

    operator fun invoke(source: T): K
}