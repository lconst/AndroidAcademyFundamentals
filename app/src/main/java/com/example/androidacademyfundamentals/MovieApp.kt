package com.example.androidacademyfundamentals

import android.app.Application
import com.example.androidacademyfundamentals.utils.NetworkModule

class MovieApp : Application() {

   val networkModule by lazy { NetworkModule() }
}

