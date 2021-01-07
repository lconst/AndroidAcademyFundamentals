package com.example.androidacademyfundamentals.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MoviesDetailsViewModelFactory(private val movieId: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesDetailsViewModel::class.java -> MoviesDetailsViewModel(movieId)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}