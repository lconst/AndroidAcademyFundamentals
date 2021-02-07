package com.example.androidacademyfundamentals.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidacademyfundamentals.model.database.models.MovieDetailsEntity
import com.example.androidacademyfundamentals.model.database.models.MoviesEntity
import com.example.androidacademyfundamentals.model.models.MovieDetails

@Database(entities = [MoviesEntity::class, MovieDetailsEntity::class], version = 2)
abstract class MoviesDataBase: RoomDatabase() {

    abstract val moviesDao: MoviesDao

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