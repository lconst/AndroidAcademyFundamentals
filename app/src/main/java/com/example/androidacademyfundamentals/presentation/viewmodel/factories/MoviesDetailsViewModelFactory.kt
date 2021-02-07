package com.example.androidacademyfundamentals.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.model.datasource.MoviesDataSource
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository
import com.example.androidacademyfundamentals.presentation.viewmodel.MoviesDetailsViewModel

@Suppress("UNCHECKED_CAST")
class MoviesDetailsViewModelFactory(
    private val movieId: Int,
    private val dataSource: MoviesDataSource
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesDetailsViewModel::class.java -> MoviesDetailsViewModel(movieId, dataSource)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}