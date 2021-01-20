package com.example.androidacademyfundamentals.model.movies.repositories

import com.example.androidacademyfundamentals.model.movies.entities.Genre
import com.example.androidacademyfundamentals.model.movies.entities.Movie
import com.example.androidacademyfundamentals.model.movies.network.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Movie]
 */
class MoviesRepository(private val moviesApi: MoviesApi) {

    suspend fun getPopular(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getPopularMovies()
        }.results
            .map {
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    null,
                    it.posterPath,
                    it.backdropPath,
                    it.rating,
                    it.adult,
                    it.voteCount
                )
            }
    }

    suspend fun getNowPlaying(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getNowPlayingMovies()
        }.results
            .map {
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    null,
                    it.posterPath,
                    it.backdropPath,
                    it.rating,
                    it.adult,
                    it.voteCount
                )
            }
    }

    suspend fun getDetails(movieId: Int): Movie {
        return withContext(Dispatchers.IO) {
            moviesApi.getMovieDetails(movieId)
        }.let{ detailsResponse ->
            Movie(
                    detailsResponse.id,
                    detailsResponse.title,
                    detailsResponse.overview,
                    detailsResponse.genres.map { Genre(it.name, it.id) },
                    detailsResponse.posterPath,
                    detailsResponse.backdropPath,
                    detailsResponse.rating,
                    detailsResponse.adult,
                    detailsResponse.voteCount
                )
            }
    }
}