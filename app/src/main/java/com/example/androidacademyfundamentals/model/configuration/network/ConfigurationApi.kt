package com.example.androidacademyfundamentals.model.configuration.network

import retrofit2.http.GET

interface ConfigurationApi {
    @GET("configuration")
    suspend fun getConfiguration(): ConfigurationResponse
}