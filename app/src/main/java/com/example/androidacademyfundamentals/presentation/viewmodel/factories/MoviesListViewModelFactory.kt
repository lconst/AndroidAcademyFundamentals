package com.example.androidacademyfundamentals.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.datasource.MoviesDataSource
import com.example.androidacademyfundamentals.model.models.Configuration
import com.example.androidacademyfundamentals.model.network.repositories.MoviesRepository
import com.example.androidacademyfundamentals.presentation.viewmodel.MoviesListViewModel

@Suppress("UNCHECKED_CAST")
class MoviesListViewModelFactory(
    private val dataSource: MoviesDataSource,
    private val config: Configuration
) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesListViewModel::class.java -> MoviesListViewModel(dataSource, config)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}