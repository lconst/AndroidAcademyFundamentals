package com.example.androidacademyfundamentals.utils

import com.example.androidacademyfundamentals.model.configuration.network.ConfigurationApi
import com.example.androidacademyfundamentals.model.configuration.repositories.ConfigurationRepository
import com.example.androidacademyfundamentals.model.movies.network.MoviesApi
import com.example.androidacademyfundamentals.model.movies.repositories.MoviesRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class NetworkModule {

    private val client = OkHttpClient().newBuilder()
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    private val configurationApi: ConfigurationApi = retrofit.create(ConfigurationApi::class.java)
    private val moviesApi: MoviesApi = retrofit.create(MoviesApi::class.java)

    val configurationRepo = ConfigurationRepository.getInstance(configurationApi)
    val moviesRepo = MoviesRepository(moviesApi)

    private class ApiKeyInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url

            val request = originalRequest.newBuilder()
                    .url(originalHttpUrl.newBuilder().addQueryParameter(API_KEY, API_KEY_VALUE).toString())
                    .build()

            return chain.proceed(request)
        }
    }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "api_key"
        private const val API_KEY_VALUE = "36349fb4f5fd95012e34eff921fb06e5"
    }
}