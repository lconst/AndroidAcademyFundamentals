package com.example.androidacademyfundamentals.model.movies.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class Movie(

    @SerialName("vote_average")
    private val rating: Double,

    @SerialName("adult")
    private val adult: Boolean,

    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("poster_path")
    var posterPath: String,

    @SerialName("vote_count")
    val voteCount: Int
) {

    fun getMinimumAge(): Int {
        return if (adult) 18
        else 12
    }

    fun getRating(stars: Int = 5): Float = (rating / 10 * stars).toFloat()
}