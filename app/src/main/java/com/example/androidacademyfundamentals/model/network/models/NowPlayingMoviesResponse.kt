package com.example.androidacademyfundamentals.model.network.models

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
	val results: List<MovieResultResponse>,

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
