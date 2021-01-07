package com.example.androidacademyfundamentals.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.api.Configuration

@Suppress("UNCHECKED_CAST")
class MoviesListViewModelFactory(
        private val config: Configuration
) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesListViewModel::class.java -> MoviesListViewModel(config)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}