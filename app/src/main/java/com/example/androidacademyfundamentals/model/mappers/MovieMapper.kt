package com.example.androidacademyfundamentals.model.mappers

import com.example.androidacademyfundamentals.model.database.models.MoviesEntity
import com.example.androidacademyfundamentals.model.models.Movie
import com.example.androidacademyfundamentals.model.network.models.MovieResultResponse

class MovieEntityMapper: Mapper<Movie, MoviesEntity> {

    override fun mapFrom(source: Movie): MoviesEntity =
        MoviesEntity(
            id = source.id,
            title = source.title,
            poster = source.posterPath,
            votes = source.voteCount,
            rating = source.rating,
            adult = source.adult,
            category = source.category.toString()
        )
}

class MovieModelMapper: Mapper<MovieResultResponse, Movie> {

    override fun mapFrom(source: MovieResultResponse): Movie =
        Movie(
            id = source.id,
            title = source.title,
            posterPath = source.posterPath,
            rating = source.popularity,
            adult = source.adult,
            voteCount = source.voteCount,
            category = Movie.Category.PLAYING
        )
}