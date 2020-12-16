package com.example.androidacademyfundamentals.data.json

import android.content.Context
import com.example.androidacademyfundamentals.data.*
import com.example.androidacademyfundamentals.util.readAssetFileToString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class JsonMovie(
    val id: Int,
    val title: String,
    @SerialName("poster_path")
    val posterPicture: String,
    @SerialName("backdrop_path")
    val backdropPicture: String,
    val runtime: Int,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    val actors: List<Int>,
    @SerialName("vote_average")
    val ratings: Float,
    @SerialName("vote_count")
    val votesCount: Int,
    val overview: String,
    val adult: Boolean
)

private val jsonFormat = Json { ignoreUnknownKeys = true }
@Suppress("unused")
internal suspend fun loadMovies(context: Context): List<Movie> = withContext(Dispatchers.IO) {
    val genresMap = loadGenres(context)
    val actorsMap = loadActors(context)

    val data = readAssetFileToString(context, "data.json")
    parseMovies(data, genresMap, actorsMap)
}

internal fun parseMovies(
    data: String,
    genres: List<Genre>,
    actors: List<Actor>
): List<Movie> {
    val genresMap = genres.associateBy { it.id }
    val actorsMap = actors.associateBy { it.id }

    val jsonMovies = jsonFormat.decodeFromString<List<JsonMovie>>(data)

    return jsonMovies.map { jsonMovie ->
        @Suppress("unused")
        (Movie(
        id = jsonMovie.id,
        title = jsonMovie.title,
        overview = jsonMovie.overview,
        poster = jsonMovie.posterPicture,
        backdrop = jsonMovie.backdropPicture,
        ratings = jsonMovie.ratings,
        numberOfRatings = jsonMovie.votesCount,
        minimumAge = if (jsonMovie.adult) 16 else 13,
        runtime = jsonMovie.runtime,
        genres = jsonMovie.genreIds.map {
            genresMap[it] ?: throw IllegalArgumentException("Genre not found")
        },
        actors = jsonMovie.actors.map {
            actorsMap[it] ?: throw IllegalArgumentException("Actor not found")
        }
    ))
    }
}