package com.example.androidacademyfundamentals.model.movies.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieDetailsResponse(

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("imdb_id")
    val imdbId: String,

    @SerialName("video")
    val video: Boolean,

    @SerialName("title")
    val title: String,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("revenue")
    val revenue: Int,

    @SerialName("genres")
    val genres: List<GenreNetworkModel>,

    @SerialName("popularity")
    val popularity: Double,

    @SerialName("id")
    val id: Int,

    @SerialName("vote_count")
    val voteCount: Int,

    @SerialName("budget")
    val budget: Int,

    @SerialName("overview")
    val overview: String,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("runtime")
    val runtime: Int,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("vote_average")
    val rating: Double,

    @SerialName("tagline")
    val tagline: String,

    @SerialName("adult")
    val adult: Boolean,

    @SerialName("homepage")
    val homepage: String,

    @SerialName("status")
    val status: String
) {
    fun getMinimumAge(): Int {
        return if (adult) 18
        else 12
    }

    fun getRating(stars: Int = 5): Float =  (rating / 10 * stars).toFloat()
}