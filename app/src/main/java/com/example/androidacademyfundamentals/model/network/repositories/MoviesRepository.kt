package com.example.androidacademyfundamentals.model.network.repositories

import com.example.androidacademyfundamentals.model.mappers.MovieDetailsModelMapper
import com.example.androidacademyfundamentals.model.mappers.MovieResultModelMapper
import com.example.androidacademyfundamentals.model.models.Movie
import com.example.androidacademyfundamentals.model.models.MovieDetails
import com.example.androidacademyfundamentals.model.network.api.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Movie]
 */
class MoviesRepository(private val moviesApi: MoviesApi) {

    suspend fun getPopular(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getPopularMovies()
        }.results.map { MovieResultModelMapper()(it) }
    }

    suspend fun getNowPlaying(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getNowPlayingMovies()
        }.results.map { MovieResultModelMapper()(it) }
    }

    suspend fun getDetails(movieId: Int): MovieDetails {
        return withContext(Dispatchers.IO) {
            MovieDetailsModelMapper()(moviesApi.getMovieDetails(movieId))
        }
    }
}