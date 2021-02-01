package com.example.androidacademyfundamentals.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.androidacademyfundamentals.model.movies.entities.Genre

@Entity(
    tableName = DataBaseContract.MoviesPopular.TABLE_NAME,
    indices = [Index(DataBaseContract.COLUMN_NAME_ID)]
)
class PopularMoviesEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_ID)
    val id: Int,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_TITLE)
    val title: String,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_POSTER)
    val poster: String,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_VOTES)
    val votes: Int,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_RATING)
    val rating: Double,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_ADULT)
    val adult: Boolean
)