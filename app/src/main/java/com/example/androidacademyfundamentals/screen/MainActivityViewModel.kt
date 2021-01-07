package com.example.androidacademyfundamentals.screen

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.api.Configuration
import com.example.androidacademyfundamentals.api.ConfigurationApi
import com.example.androidacademyfundamentals.api.RetrofitModule
import kotlinx.coroutines.*

class MainActivityViewModel: ViewModel() {


    private val _config = MutableLiveData<Configuration>()
    val config : LiveData<Configuration> get() = _config

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    private val retrofitModule = RetrofitModule()

    fun loadConfig() {
        viewModelScope.launch(exceptionHandler) {
            _config.value = retrofitModule.configurationApi.getConfiguration()
        }
    }

    companion object {
        val TAG = MainActivityViewModel::class.java.simpleName
    }

}