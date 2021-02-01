package com.example.androidacademyfundamentals.presentation.details.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidacademyfundamentals.model.movies.entities.Movie
import com.example.androidacademyfundamentals.model.movies.entities.MovieDetails
import com.example.androidacademyfundamentals.model.movies.repositories.MoviesRepository
import kotlinx.coroutines.*

class MoviesDetailsViewModel(private val movieId: Int, private val repository: MoviesRepository): ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails: LiveData<MovieDetails> get() = _movieDetails

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    fun loadMovieDetails() {
        coroutineScope.launch(exceptionHandler) {
            _movieDetails.postValue(repository.getDetails(movieId))
        }
    }

    companion object {
        private val TAG = MoviesDetailsViewModel::class.java.simpleName
    }
}