package com.example.androidacademyfundamentals.model.movies.network

import com.example.androidacademyfundamentals.model.movies.entities.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class NowPlayingMoviesResponse(

    @SerialName("dates")
    val dates: Dates,

    @SerialName("page")
    val page: Int,

    @SerialName("total_pages")
    val totalPages: Int,

    @SerialName("results")
    val results: List<Movie>,

    @SerialName("total_results")
    val totalResults: Int
)

@Serializable
class Dates(

    @SerialName("maximum")
    val maximum: String,

    @SerialName("minimum")
    val minimum: String
)