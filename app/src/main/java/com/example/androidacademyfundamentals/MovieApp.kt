package com.example.androidacademyfundamentals

import android.app.Application
import com.example.androidacademyfundamentals.model.database.MoviesDataBase
import com.example.androidacademyfundamentals.model.network.NetworkModule

class MovieApp : Application() {

    val networkModule by lazy { NetworkModule() }
    val database by lazy { MoviesDataBase.create(applicationContext) }
}

