package com.example.androidacademyfundamentals.api

import com.example.androidacademyfundamentals.data.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

@Serializable
class PopularMoviesResponse(

	@SerialName("page")
	val page: Int,

	@SerialName("total_pages")
	val totalPages: Int,

	@SerialName("results")
	val results: List<Movie>,

	@SerialName("total_results")
	val totalResults: Int
)

interface PopularMoviesApi {
	@GET("movie/popular")
	suspend fun getPopularMovies(): PopularMoviesResponse
}
