package com.example.androidacademyfundamentals.model.movies.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieDetails(

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
    val voteCount: Int,

    @SerialName("overview")
    val overview: String,

    @SerialName("genres")
    val genre: List<Genre>,

    @SerialName("backdrop_path")
    val backdropPath: String,
){
    fun getMinimumAge(): Int {
        return if (adult) 18
        else 12
    }

    fun getRating(stars: Int = 5): Float = (rating / 10 * stars).toFloat()
}