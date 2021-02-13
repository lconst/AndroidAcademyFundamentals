package com.example.androidacademyfundamentals

import android.app.Application
import android.content.Context

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = AppComponent(this)
    }

    companion object {

        lateinit var instance: MovieApp
            private set

        lateinit var appComponent: AppComponent
            private set

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }
}

