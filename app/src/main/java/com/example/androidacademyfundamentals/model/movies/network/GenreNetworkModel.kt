package com.example.androidacademyfundamentals.model.movies.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GenreNetworkModel(

    @SerialName("name")
    val name: String,

    @SerialName("id")
    val id: Int
)