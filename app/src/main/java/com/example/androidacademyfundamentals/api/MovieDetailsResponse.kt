package com.example.androidacademyfundamentals.api

import com.example.androidacademyfundamentals.data.Genre
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Path

@Serializable
class MovieDetailsResponse(

	@SerialName("original_language")
	val originalLanguage: String? = null,

	@SerialName("imdb_id")
	val imdbId: String? = null,

	@SerialName("video")
	val video: Boolean? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null,

	@SerialName("revenue")
	val revenue: Int? = null,

	@SerialName("genres")
	val genres: List<Genre>? = null,

	@SerialName("popularity")
	val popularity: Double? = null,

	@SerialName("production_countries")
	val productionCountries: List<ProductionCountriesItem>? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("vote_count")
	val voteCount: Int? = null,

	@SerialName("budget")
	val budget: Int? = null,

	@SerialName("overview")
	val overview: String? = null,

	@SerialName("original_title")
	val originalTitle: String? = null,

	@SerialName("runtime")
	val runtime: Int? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("spoken_languages")
	val spokenLanguages: List<SpokenLanguagesItem>? = null,

	@SerialName("production_companies")
	val productionCompanies: List<ProductionCompaniesItem>? = null,

	@SerialName("release_date")
	val releaseDate: String? = null,

	@SerialName("vote_average")
	val rating: Double? = null,

	@SerialName("belongs_to_collection")
	val belongsToCollection: BelongsToCollection? = null,

	@SerialName("tagline")
	val tagline: String? = null,

	@SerialName("adult")
	val adult: Boolean? = null,

	@SerialName("homepage")
	val homepage: String? = null,

	@SerialName("status")
	val status: String? = null
) {
	fun getMinimumAge(): Int {
		adult?.let { if (adult) return 18 }
		return 12
	}

	fun getRating(stars: Int = 5): Float = rating?.let { (rating / 10 * stars).toFloat() } ?: 0f
}


@Serializable
class ProductionCountriesItem(

	@SerialName("iso_3166_1")
	val iso31661: String? = null,

	@SerialName("name")
	val name: String? = null
)

@Serializable
class SpokenLanguagesItem(

	@SerialName("name")
	val name: String? = null,

	@SerialName("iso_639_1")
	val iso6391: String? = null
)

@Serializable
class ProductionCompaniesItem(

	@SerialName("logo_path")
	val logoPath: String? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("origin_country")
	val originCountry: String? = null
)

@Serializable
class BelongsToCollection(

	@SerialName("id")
	val id: Int? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null
)

interface MovieDetailsApi{
	@GET("movie/{movie_id}")
	suspend fun getMovieDetails(@Path("movie_id") movieId: Int) : MovieDetailsResponse
}
