package com.example.androidacademyfundamentals.screen.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED")
class MoviesListViewModelFactory(private val application: Application):
    ViewModelProvider.AndroidViewModelFactory(application)
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesListViewModel::class.java -> MoviesListViewModel(application)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}