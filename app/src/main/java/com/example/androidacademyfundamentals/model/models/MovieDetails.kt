package com.example.androidacademyfundamentals.model.models

class MovieDetails(
    val id: Int,
    val title: String,
    val voteCount: Int,
    val overview: String,
    val genre: List<Genre>,
    val backdropPath: String,
    val rating: Double,
    val adult: Boolean,
) {
    fun getMinimumAge(): Int {
        return if (adult) 18
        else 12
    }

    fun getRating(stars: Int = 5): Float = (rating / 10 * stars).toFloat()
}
