package com.example.androidacademyfundamentals.model.datasource

import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.mappers.MovieDetailsEntityMapper
import com.example.androidacademyfundamentals.model.mappers.MovieEntityDetailsModelMapper
import com.example.androidacademyfundamentals.model.mappers.MovieEntityModelMapper
import com.example.androidacademyfundamentals.model.mappers.MoviePopularModelEntityMapper
import com.example.androidacademyfundamentals.model.models.Movie
import com.example.androidacademyfundamentals.model.models.MovieDetails
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesDataSource(
    private val networkRepository: MoviesRepository,
    private val database: MoviesDataBase) {

    suspend fun getPopularMovies(): List<Movie> {
        var result = database.moviesDao.getPopular().map { MovieEntityModelMapper()(it) }
        if (result.isEmpty()) {
            result = networkRepository.getPopular()
            saveMovies(result)
        }
        return result
    }

    suspend fun getDetails(id: Int): MovieDetails {
        val details = database.moviesDao.getDetails(id)
        var result = details?.let { MovieEntityDetailsModelMapper()(details) }
        if (result == null) {
            result = networkRepository.getDetails(id)
            database.moviesDao.putDetails(MovieDetailsEntityMapper()(result))
        }
        return result
    }

    suspend fun refreshData() {
        saveMovies(networkRepository.getPopular())
    }

    private suspend fun saveMovies(movies: List<Movie>) = withContext(Dispatchers.IO) {
        for (item in movies) {
            database.moviesDao.insert(MoviePopularModelEntityMapper()(item))
        }
    }
}