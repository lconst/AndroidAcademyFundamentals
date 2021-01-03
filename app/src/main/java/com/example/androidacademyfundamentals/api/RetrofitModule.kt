package com.example.androidacademyfundamentals.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


class RetrofitModule {

    private val baseUrl = "https://api.themoviedb.org/3/"

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val configurationApi: ConfigurationApi = retrofit.create(ConfigurationApi::class.java)
    val popularMoviesApi: PopularMoviesApi = retrofit.create(PopularMoviesApi::class.java)

    private class ApiKeyInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url

            val request = originalRequest.newBuilder()
                .url(originalHttpUrl.newBuilder().addQueryParameter(API_KEY, apiKeyValue).toString())
                .build()

            return chain.proceed(request)
        }
    }
}



private const val API_KEY = "api_key"
private const val apiKeyValue: String = "36349fb4f5fd95012e34eff921fb06e5"