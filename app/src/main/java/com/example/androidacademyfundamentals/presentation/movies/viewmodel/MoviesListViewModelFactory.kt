package com.example.androidacademyfundamentals.presentation.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.model.movies.repositories.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesListViewModelFactory(
    private val repository: MoviesRepository,
    private val config: Configuration
) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesListViewModel::class.java -> MoviesListViewModel(repository, config)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}