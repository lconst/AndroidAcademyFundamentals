package com.example.androidacademyfundamentals.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.model.models.Configuration
import com.example.androidacademyfundamentals.model.network.repositories.ConfigurationRepository
import kotlinx.coroutines.*

class MainActivityViewModel(private val configurationRepository: ConfigurationRepository): ViewModel() {

    private val _config = MutableLiveData<Configuration>()
    val config : LiveData<Configuration> get() = _config

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    fun loadConfig() {
        viewModelScope.launch(exceptionHandler) {
            _config.value = configurationRepository.getConfiguration()
        }
    }

    companion object {
        private val TAG = MainActivityViewModel::class.java.simpleName
    }

}