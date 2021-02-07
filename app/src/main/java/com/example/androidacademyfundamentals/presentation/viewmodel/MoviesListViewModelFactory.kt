package com.example.androidacademyfundamentals.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.models.Configuration
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesListViewModelFactory(
    private val database: MoviesDataBase,
    private val repository: MoviesRepository,
    private val config: Configuration
) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesListViewModel::class.java -> MoviesListViewModel(database, repository, config)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}