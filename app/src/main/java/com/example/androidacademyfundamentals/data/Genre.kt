package com.example.androidacademyfundamentals.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Genre(

    @SerialName("name")
    val name: String,

    @SerialName("id")
    val id: Int
)