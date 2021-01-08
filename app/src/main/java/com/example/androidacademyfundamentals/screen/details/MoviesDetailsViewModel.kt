package com.example.androidacademyfundamentals.screen.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidacademyfundamentals.api.MovieDetailsResponse
import com.example.androidacademyfundamentals.api.RetrofitModule
import kotlinx.coroutines.*

class MoviesDetailsViewModel(private val movieId: Int): ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetailsResponse>()
    val movieDetails: LiveData<MovieDetailsResponse> get() = _movieDetails

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    fun loadMovieDetails() {
        coroutineScope.launch(exceptionHandler) {
            _movieDetails.postValue(RetrofitModule.movieDetailsApi.getMovieDetails(movieId))
        }
    }

    companion object {
        private val TAG = MoviesDetailsViewModel::class.java.simpleName
    }
}