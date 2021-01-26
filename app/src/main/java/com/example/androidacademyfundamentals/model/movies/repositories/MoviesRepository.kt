package com.example.androidacademyfundamentals.model.movies.repositories

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
        }.results.map { it.mapper() }
    }

    suspend fun getNowPlaying(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getNowPlayingMovies()
        }.results.map { it.mapper() }
    }

    suspend fun getDetails(movieId: Int): Movie {
        return withContext(Dispatchers.IO) {
            moviesApi.getMovieDetails(movieId)
        }.mapper()
    }
}