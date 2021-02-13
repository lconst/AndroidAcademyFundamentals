package com.example.androidacademyfundamentals.model.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Details"
)
class MovieDetailsEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "votes")
    val votes: Int,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "backdrop")
    val backdrop: String,

)