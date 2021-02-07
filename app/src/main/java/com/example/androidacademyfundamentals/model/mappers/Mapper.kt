package com.example.androidacademyfundamentals.model.mappers

interface Mapper<T, K> {

    fun mapFrom(source: T): K
}