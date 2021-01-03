package com.example.androidacademyfundamentals.screen.list

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.api.*
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.util.AssetsProvider
import kotlinx.coroutines.*

class MoviesListViewModel(private val assertsProvider: AssetsProvider): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>(emptyList())
    //val movies: LiveData<List<Movie>> get() = _movies

    val movies: LiveData<List<Movie>> = Transformations.map(_movies) { list ->
        list.forEach {
            it.posterPath =
                config.images.baseUrl + config.images.posterSizes[3] + it.posterPath
        }
        list
    }

    private lateinit var config: ConfigurationResponse

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    private val retrofitModule = RetrofitModule()

    fun loadMovies() {
        viewModelScope.launch(exceptionHandler) {
           // _movies.value = loadMovies(assertsProvider)

            config = retrofitModule.configurationApi.getConfiguration()
            _movies.value = retrofitModule.popularMoviesApi.getPopularMovies().results
        }

    }



    companion object {
        private val TAG = MoviesListViewModel::class.java.simpleName
    }

}
