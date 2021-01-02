package com.example.androidacademyfundamentals.screen.list

import android.util.Log
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.api.ApiKeyInterceptor
import com.example.androidacademyfundamentals.api.BaseAPI
import com.example.androidacademyfundamentals.api.ConfigurationApi
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.data.json.loadMovies
import com.example.androidacademyfundamentals.util.AssetsProvider
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class MoviesListViewModel(private val assertsProvider: AssetsProvider): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>(emptyList())
    val movies: LiveData<List<Movie>> get() = _movies

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception, scope active:${coroutineScope.isActive}", throwable)
        coroutineScope
    }

    fun loadMovies() {
        viewModelScope.launch(exceptionHandler) {
            _movies.value = loadMovies(assertsProvider)

            val response = RetrofitModule.configurationApi.getConfiguration()
        }
    }

    private object RetrofitModule {
        private val client = OkHttpClient().newBuilder()
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        private val json = Json {
            ignoreUnknownKeys = true
        }

        private val retrofit: Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BaseAPI.getBaseUrl())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        val configurationApi: ConfigurationApi = retrofit.create(ConfigurationApi::class.java)
    }

    companion object {
        private const val MOVIES_REQUEST_ENDPOINT = "movie/now_playing"
        private val TAG = MoviesListViewModel::class.java.simpleName
    }

}
