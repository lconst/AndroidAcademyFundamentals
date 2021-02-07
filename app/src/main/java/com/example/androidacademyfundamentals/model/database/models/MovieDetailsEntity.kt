package com.example.androidacademyfundamentals.model.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.androidacademyfundamentals.model.database.DataBaseContract

@Entity(
    tableName = DataBaseContract.MoviesDetails.TABLE_NAME,
    indices = [Index(DataBaseContract.COLUMN_NAME_ID)]
)
class MovieDetailsEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_ID)
    val id: Int,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_TITLE)
    val title: String,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_VOTES)
    val votes: Int,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_RATING)
    val rating: Double,

    @ColumnInfo(name = DataBaseContract.COLUMN_NAME_ADULT)
    val adult: Boolean,

    @ColumnInfo(name = DataBaseContract.MoviesDetails.COLUMN_NAME_OVERVIEW)
    val overview: String,

    @ColumnInfo(name = DataBaseContract.MoviesDetails.COLUMN_NAME_GENRES)
    val genre: String,

    @ColumnInfo(name = DataBaseContract.MoviesDetails.COLUMN_NAME_BACKDROP)
    val backdrop: String,

)

