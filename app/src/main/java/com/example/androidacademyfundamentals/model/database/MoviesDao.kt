package com.example.androidacademyfundamentals.model.database

import androidx.room.*
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: MoviesEntity)

    @Query("DELETE FROM Movies")
    suspend fun deleteMoviesTable()

    @Insert
    suspend fun putDetails(movies: MovieDetailsEntity)
}