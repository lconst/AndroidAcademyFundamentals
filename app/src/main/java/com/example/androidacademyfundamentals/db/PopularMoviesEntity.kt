package com.example.androidacademyfundamentals.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.androidacademyfundamentals.model.movies.entities.Genre

@Entity(
        tableName = DataBaseContract.MoviesPopular.TABLE_NAME,
        indices = [Index(DataBaseContract.MoviesPopular.COLUMN_NAME_ID)]
)
class PopularMoviesEntity(

        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = DataBaseContract.MoviesPopular.COLUMN_NAME_ID)
        val id: Int,

        @ColumnInfo(name = DataBaseContract.MoviesPopular.COLUMN_NAME_TITLE)
        val title: String,

        @ColumnInfo(name = DataBaseContract.MoviesPopular.COLUMN_NAME_OVERVIEW)
        val overview: String,

        @ColumnInfo(name = DataBaseContract.MoviesPopular.COLUMN_NAME_GENRES)
        val genre: List<Genre>?,


        val poster: String,
        val backdrop: String,
        val votes: Int,
        val rating: Double,
        val adult: Boolean
)