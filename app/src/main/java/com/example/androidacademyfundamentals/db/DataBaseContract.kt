package com.example.androidacademyfundamentals.db

import android.provider.BaseColumns

object DataBaseContract {

    const val DATABASE_NAME = "Movies.db"

    object MoviesPopular {

        const val TABLE_NAME = "Popular"

        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_OVERVIEW = "overview"
        const val COLUMN_NAME_GENRES = "genre"
        const val COLUMN_NAME_POSTER = "poster"
        const val COLUMN_NAME_BACKDROP = "backdrop"
        const val COLUMN_NAME_VOTES = "votes"
        const val COLUMN_NAME_RATING = "rating"
        const val COLUMN_NAME_ADULT = "adult"
    }

    object MoviesNowPlaying {

        const val TABLE_NAME = "Playing"

        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_OVERVIEW = "overview"
        const val COLUMN_NAME_GENRES = "genre"
        const val COLUMN_NAME_POSTER = "poster"
        const val COLUMN_NAME_BACKDROP = "backdrop"
        const val COLUMN_NAME_VOTES = "votes"
        const val COLUMN_NAME_RATING = "rating"
        const val COLUMN_NAME_ADULT = "adult"
    }

}