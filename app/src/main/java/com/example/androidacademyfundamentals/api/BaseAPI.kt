package com.example.androidacademyfundamentals.api

import com.example.androidacademyfundamentals.api.BaseAPI.Companion.getApiKey
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class BaseAPI {

    companion object {

        fun getBaseUrl(): String = "https://api.themoviedb.org/3/"

        fun getApiKey(): String = apiKey

    }
}


class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val request = originalRequest.newBuilder()
            .url(originalHttpUrl.newBuilder().addQueryParameter(API_KEY, getApiKey()).toString())
            .build()

        return chain.proceed(request)
    }
}

private const val API_KEY = "api_key"
private const val apiKey = "36349fb4f5fd95012e34eff921fb06e5"