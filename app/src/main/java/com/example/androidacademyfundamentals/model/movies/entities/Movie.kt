package com.example.androidacademyfundamentals.model.movies.entities

class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val genre: List<Genre>?,
    var posterPath: String,
    val backdropPath: String,
    private val rating: Double,
    private val adult: Boolean,
    val voteCount: Int
) {

    fun getMinimumAge(): Int {
        return if (adult) 18
        else 12
    }

    fun getRating(stars: Int = 5): Float = (rating / 10 * stars).toFloat()
}