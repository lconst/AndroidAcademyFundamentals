package com.example.androidacademyfundamentals.presentation.movies.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.model.configuration.entities.PosterSizes
import com.example.androidacademyfundamentals.model.movies.entities.Movie
import com.example.androidacademyfundamentals.model.movies.repositories.MoviesRepository
import kotlinx.coroutines.*

class MoviesListViewModel(
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
            _movies.value = repository.getNowPlaying()
        }
    }

    companion object {
        private val TAG = MoviesListViewModel::class.java.simpleName
    }

}
