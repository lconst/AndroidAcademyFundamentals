package com.example.androidacademyfundamentals

import android.content.Context
import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.datasource.MoviesDataSource
import com.example.androidacademyfundamentals.model.network.NetworkModule

class AppComponent(context: Context) {

    val networkModule by lazy { NetworkModule() }
    val database by lazy { MoviesDataBase.create(context) }
    val movieDataSource by lazy { MoviesDataSource(networkModule.moviesRepo, database) }
}