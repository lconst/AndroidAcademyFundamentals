package com.example.androidacademyfundamentals.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesDetailsViewModelFactory(
    private val movieId: Int,
    private val repository: MoviesRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesDetailsViewModel::class.java -> MoviesDetailsViewModel(movieId, repository)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}