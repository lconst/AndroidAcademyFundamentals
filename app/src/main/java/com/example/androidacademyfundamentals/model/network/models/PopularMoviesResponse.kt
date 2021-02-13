package com.example.androidacademyfundamentals.model.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class PopularMoviesResponse(

	@SerialName("page")
	val page: Int,

	@SerialName("results")
	val results: List<MovieResultResponse>,

	@SerialName("total_pages")
	val totalPages: Int,

	@SerialName("total_results")
	val totalResults: Int
)
