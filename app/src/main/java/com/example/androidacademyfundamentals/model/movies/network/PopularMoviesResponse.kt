package com.example.androidacademyfundamentals.model.movies.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class PopularMoviesResponse(

    @SerialName("page")
    val page: Int,

    @SerialName("total_pages")
    val totalPages: Int,

    @SerialName("results")
    val results: List<MovieNetworkModel>,

    @SerialName("total_results")
    val totalResults: Int
)