package com.example.androidacademyfundamentals.model.datasource

import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.mappers.MovieDetailsEntityMapper
import com.example.androidacademyfundamentals.model.mappers.MovieEntityDetailsModelMapper
import com.example.androidacademyfundamentals.model.mappers.MovieEntityModelMapper
import com.example.androidacademyfundamentals.model.mappers.MoviePopularModelEntityMapper
import com.example.androidacademyfundamentals.model.models.Movie
import com.example.androidacademyfundamentals.model.models.MovieDetails
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository

class MoviesDataSource(

    private val networkRepository: MoviesRepository,
    private val database: MoviesDataBase) {

    suspend fun getPopularMovies(): List<Movie> {
        var result = database.moviesDao.getPopular().map { MovieEntityModelMapper().mapFrom(it) }
        if (result.isEmpty()) {
            result = networkRepository.getPopular()
            for (item in result) {
                database.moviesDao.insert(MoviePopularModelEntityMapper().mapFrom(item))
            }
        }
        return result
    }

    suspend fun getDetails(id: Int): MovieDetails {
        val details = database.moviesDao.getDetails(id)
        var result = details?.let { MovieEntityDetailsModelMapper().mapFrom(details) }
        if (result == null) {
            result = networkRepository.getDetails(id)
            database.moviesDao.putDetails(MovieDetailsEntityMapper().mapFrom(result))
        }
        return result
    }
}