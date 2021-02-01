package com.example.androidacademyfundamentals.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Popular")
    suspend fun getPopular(): List<PopularMoviesEntity>

    @Query("SELECT * FROM Playing")
    suspend fun getNowPlaying(): List<NowPlayingMoviesEntity>

    @Query("SELECT * FROM Details WHEN")
    suspend fun getDetails(id: Int): MovieDetailsEntity
}