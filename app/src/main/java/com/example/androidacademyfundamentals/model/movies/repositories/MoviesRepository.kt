package com.example.androidacademyfundamentals.model.movies.repositories

import android.content.Context
import com.example.androidacademyfundamentals.db.MoviesDataBase
import com.example.androidacademyfundamentals.model.movies.entities.Movie
import com.example.androidacademyfundamentals.model.movies.entities.MovieDetails
import com.example.androidacademyfundamentals.model.movies.network.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Movie]
 */
class MoviesRepository(private val moviesApi: MoviesApi) {

    //private val moviesDb = MoviesDataBase.create(applicationContext)

    suspend fun getPopular(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getPopularMovies()
        }.results
    }

    suspend fun getNowPlaying(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesApi.getNowPlayingMovies()
        }.results
    }

    suspend fun getDetails(movieId: Int): MovieDetails {
        return withContext(Dispatchers.IO) {
            moviesApi.getMovieDetails(movieId)
        }
    }
}