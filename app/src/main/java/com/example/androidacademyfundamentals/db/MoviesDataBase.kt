package com.example.androidacademyfundamentals.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.model.movies.entities.Movie

@Database(entities = [Configuration::class, Movie::class], version = 1)
abstract class MoviesDataBase: RoomDatabase() {

    abstract val nowPlayingMoviesDao: NowPlayingMoviesDao

    companion object {

        fun create(applicationContext: Context): MoviesDataBase = Room.databaseBuilder(
            applicationContext,
            MoviesDataBase::class.java,
            DataBaseContract.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}