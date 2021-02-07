package com.example.androidacademyfundamentals.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.mappers.MovieEntityMapper
import com.example.androidacademyfundamentals.model.models.Configuration
import com.example.androidacademyfundamentals.model.models.PosterSizes
import com.example.androidacademyfundamentals.model.models.Movie
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository
import kotlinx.coroutines.*

class MoviesListViewModel(
    private val database: MoviesDataBase,
    private val repository: MoviesRepository,
    private val config: Configuration
) : ViewModel()
{
    private val _movies = MutableLiveData<List<Movie>>(emptyList())

    val movies: LiveData<List<Movie>> = Transformations.map(_movies) { list ->
        list.forEach {
            it.posterPath =
                config.baseUrl + config.posterSizes[PosterSizes.w342.ordinal] + it.posterPath
        }
        list
    }

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    fun loadMovies() {
        viewModelScope.launch(exceptionHandler) {
            _movies.value = repository.getPopular()
            movies.value?.map { saveInDatabase(it) }
        }
    }

    fun saveInDatabase(movie: Movie) {
        viewModelScope.launch(exceptionHandler) {
            database.moviesDao.insert(MovieEntityMapper().mapFrom(movie))
        }
    }

    companion object {
        private val TAG = MoviesListViewModel::class.java.simpleName
    }

}
