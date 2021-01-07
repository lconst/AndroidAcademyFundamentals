package com.example.androidacademyfundamentals.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass){
        MainActivityViewModel::class.java -> MainActivityViewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}