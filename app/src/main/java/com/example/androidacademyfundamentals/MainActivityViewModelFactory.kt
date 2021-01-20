package com.example.androidacademyfundamentals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyfundamentals.model.configuration.repositories.ConfigurationRepository

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory(private val repository: ConfigurationRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass){
        MainActivityViewModel::class.java -> MainActivityViewModel(repository)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}