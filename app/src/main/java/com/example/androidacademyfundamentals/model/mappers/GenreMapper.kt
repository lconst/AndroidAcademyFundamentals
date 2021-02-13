package com.example.androidacademyfundamentals.model.mappers

import com.example.androidacademyfundamentals.model.models.Genre
import com.example.androidacademyfundamentals.model.network.models.GenresItem

class GenreMapper: Mapper<GenresItem, Genre> {

    override fun invoke(source: GenresItem): Genre = Genre(source.name, source.id)
}