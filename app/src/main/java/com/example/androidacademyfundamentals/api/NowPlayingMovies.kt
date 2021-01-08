package com.example.androidacademyfundamentals.api

import com.example.androidacademyfundamentals.data.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

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

interface NowPlayingMoviesApi {
	@GET("movie/now_playing")
	suspend fun getNowPlayingMovies(): NowPlayingMoviesResponse
}
