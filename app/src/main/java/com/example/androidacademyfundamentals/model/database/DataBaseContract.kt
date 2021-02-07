package com.example.androidacademyfundamentals.model.database

import android.provider.BaseColumns

object DataBaseContract {

    const val DATABASE_NAME = "Movies.db"

    const val COLUMN_NAME_ID = BaseColumns._ID
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_POSTER = "poster"
    const val COLUMN_NAME_VOTES = "votes"
    const val COLUMN_NAME_RATING = "rating"
    const val COLUMN_NAME_ADULT = "adult"

    object Movies {
        const val TABLE_NAME = "Movies"

        const val COLUMN_NAME_CATEGORY = "category"
    }

    object MoviesDetails {
        const val TABLE_NAME = "Details"

        const val COLUMN_NAME_OVERVIEW = "overview"
        const val COLUMN_NAME_GENRES = "genre"
        const val COLUMN_NAME_BACKDROP = "backdrop"
    }


}