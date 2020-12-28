package com.example.androidacademyfundamentals.screen.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.util.AssetsProvider

@Suppress("UNCHECKED")
class MoviesListViewModelFactory(private val assetsProvider: AssetsProvider):
    ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesListViewModel::class.java -> MoviesListViewModel(assetsProvider)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}