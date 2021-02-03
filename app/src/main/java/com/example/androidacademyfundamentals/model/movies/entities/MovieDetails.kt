package com.example.androidacademyfundamentals.model.movies.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieDetails(

    @Serializable
    val movieReview: Movie,

    @SerialName("overview")
    val overview: String,

    @SerialName("genres")
    val genre: List<Genre>,

    @SerialName("backdrop_path")
    val backdropPath: String,
){
//    fun getMinimumAge(): Int {
//        return if (adult) 18
//        else 12
//    }
//
//    fun getRating(stars: Int = 5): Float = (rating / 10 * stars).toFloat()
}