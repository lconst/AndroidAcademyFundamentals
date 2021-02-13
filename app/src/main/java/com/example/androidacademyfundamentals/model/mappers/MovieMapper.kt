package com.example.androidacademyfundamentals.model.mappers

import com.example.androidacademyfundamentals.model.database.models.MovieDetailsEntity
import com.example.androidacademyfundamentals.model.database.models.MoviesEntity
import com.example.androidacademyfundamentals.model.models.Movie
import com.example.androidacademyfundamentals.model.models.MovieDetails
import com.example.androidacademyfundamentals.model.network.models.MovieResultResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MoviePopularModelEntityMapper: Mapper<Movie, MoviesEntity> {

    override fun invoke(source: Movie): MoviesEntity =
        MoviesEntity(
            id = source.id,
            title = source.title,
            poster = source.posterPath,
            votes = source.voteCount,
            rating = source.rating,
            adult = source.adult,
            category = Category.POPULAR.toString()
        )
}

class MoviePlayingModelEntityMapper: Mapper<Movie, MoviesEntity> {

    override fun invoke(source: Movie): MoviesEntity =
        MoviesEntity(
            id = source.id,
            title = source.title,
            poster = source.posterPath,
            votes = source.voteCount,
            rating = source.rating,
            adult = source.adult,
            category = Category.PLAYING.toString()
        )
}

class MovieFavoriteModelEntityMapper: Mapper<Movie, MoviesEntity> {

    override fun invoke(source: Movie): MoviesEntity =
        MoviesEntity(
            id = source.id,
            title = source.title,
            poster = source.posterPath,
            votes = source.voteCount,
            rating = source.rating,
            adult = source.adult,
            category = Category.FAVORITE.toString()
        )
}

class MovieResultModelMapper: Mapper<MovieResultResponse, Movie> {

    override fun invoke(source: MovieResultResponse): Movie =
        Movie(
            id = source.id,
            title = source.title,
            posterPath = source.posterPath,
            rating = source.popularity,
            adult = source.adult,
            voteCount = source.voteCount
        )
}

class MovieEntityModelMapper: Mapper<MoviesEntity, Movie> {

    override fun invoke(source: MoviesEntity): Movie =
        Movie(
            id = source.id,
            title = source.title,
            posterPath = source.poster,
            voteCount = source.votes,
            rating = source.rating,
            adult = source.adult
        )
}

class MovieEntityDetailsModelMapper: Mapper<MovieDetailsEntity, MovieDetails> {

    override fun invoke(source: MovieDetailsEntity): MovieDetails =
        MovieDetails(
            id = source.id,
            title = source.title,
            voteCount = source.votes,
            overview = source.overview,
            genres =  Json.decodeFromString(source.genre),
            rating = source.rating,
            backdropPath = source.backdrop,
            adult = source.adult
        )
}

class MovieDetailsEntityMapper: Mapper<MovieDetails, MovieDetailsEntity> {

    override fun invoke(source: MovieDetails): MovieDetailsEntity =
        MovieDetailsEntity(
            id = source.id,
            title = source.title,
            votes = source.voteCount,
            overview = source.overview,
            genre =  Json.encodeToString(source.genres),
            rating = source.rating,
            backdrop = source.backdropPath,
            adult = source.adult
        )
}

enum class Category{POPULAR, PLAYING, FAVORITE}