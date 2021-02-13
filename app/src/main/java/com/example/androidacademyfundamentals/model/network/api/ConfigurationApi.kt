package com.example.androidacademyfundamentals.model.network.api

import com.example.androidacademyfundamentals.model.network.models.ConfigurationResponse
import retrofit2.http.GET

interface ConfigurationApi {
    @GET("configuration")
    suspend fun getConfiguration(): ConfigurationResponse
}