package com.example.androidacademyfundamentals.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Movie(

    @SerialName("overview")
    val overview: String,

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("video")
    val video: Boolean,

    @SerialName("title")
    val title: String,

    @SerialName("genre_ids")
    val genreIds: List<Int?>,

    @SerialName("poster_path")
    var posterPath: String,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("popularity")
    val rating: Double,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("id")
    val id: Int,

    @SerialName("adult")
    val adult: Boolean,

    @SerialName("vote_count")
    val voteCount: Int
) {

    fun getMinimumAge(): Int {
        return if (adult) 18
        else 13
    }

    fun getRating(stars: Int): Float = (rating / 10 * stars).toFloat()
}