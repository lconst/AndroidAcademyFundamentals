package com.example.androidacademyfundamentals.model.models

class Movie(
    val id: Int,
    val title: String,
    var posterPath: String,
    val voteCount: Int,
    val rating: Double,
    val adult: Boolean

) {

    fun getMinimumAge(): Int {
        return if (adult) 18
        else 12
    }

    fun getRating(stars: Int = 5): Float = (rating / 10 * stars).toFloat()

}
