package com.example.androidacademyfundamentals.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidacademyfundamentals.model.database.models.MoviesEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Movies")
    suspend fun getPopular(): List<MoviesEntity>

    @Query("SELECT * FROM Movies")
    suspend fun getNowPlaying(): List<MoviesEntity>

//    @Query("SELECT * FROM Details WHERE _id LIKE :id")
//    suspend fun getDetails(id: Int): MovieDetailsEntity

    @Insert
    suspend fun insert(movies: MoviesEntity)
}