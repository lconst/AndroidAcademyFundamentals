package com.example.androidacademyfundamentals.screen.list

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.api.*
import com.example.androidacademyfundamentals.data.Movie
import kotlinx.coroutines.*

class MoviesListViewModel(
        private val config: Configuration
) : ViewModel()
{
    private val _movies = MutableLiveData<List<Movie>>(emptyList())

    val movies: LiveData<List<Movie>> = Transformations.map(_movies) { list ->
        list.forEach {
            it.posterPath =
                config.images.baseUrl + config.images.posterSizes[PosterSize.w342.ordinal] + it.posterPath
        }
        list
    }

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    private val retrofitModule = RetrofitModule()

    fun loadMovies() {
        viewModelScope.launch(exceptionHandler) {
            _movies.value = retrofitModule.popularMoviesApi.getPopularMovies().results
        }
    }

    companion object {
        private val TAG = MoviesListViewModel::class.java.simpleName
    }

    enum class PosterSize() {
        w92,
        w154,
        w185,
        w342,
        w500,
        w780,
        original
    }
}
