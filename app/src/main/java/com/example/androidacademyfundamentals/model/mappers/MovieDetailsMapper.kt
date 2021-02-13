package com.example.androidacademyfundamentals.model.mappers

import com.example.androidacademyfundamentals.model.models.MovieDetails
import com.example.androidacademyfundamentals.model.network.models.MovieDetailsResponse

class MovieDetailsModelMapper: Mapper<MovieDetailsResponse, MovieDetails> {
    override fun invoke(source: MovieDetailsResponse) = MovieDetails(
        id = source.id,
        title = source.title,
        voteCount = source.voteCount,
        overview = source.overview,
        genres = source.genres.map { GenreMapper()(it) },
        backdropPath = source.backdropPath,
        rating = source.voteAverage,
        adult = source.adult
    )
}