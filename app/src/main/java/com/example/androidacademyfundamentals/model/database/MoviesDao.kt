package com.example.androidacademyfundamentals.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidacademyfundamentals.model.database.models.MovieDetailsEntity
import com.example.androidacademyfundamentals.model.database.models.MoviesEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Movies WHERE category LIKE 'POPULAR'")
    suspend fun getPopular(): List<MoviesEntity>

    @Query("SELECT * FROM Movies WHERE category LIKE 'PLAYING'")
    suspend fun getNowPlaying(): List<MoviesEntity>

    @Query("SELECT * FROM Details WHERE id LIKE :id")
    suspend fun getDetails(id: Int): MovieDetailsEntity?

    @Insert
    suspend fun insert(movies: MoviesEntity)

    @Query("DELETE FROM Movies")
    suspend fun deleteMoviesTable()

    @Insert
    suspend fun putDetails(movies: MovieDetailsEntity)
}