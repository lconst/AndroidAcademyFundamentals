package com.example.androidacademyfundamentals.model.configuration.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Business class of Configuration
 */
@Parcelize
class Configuration(
    val posterSizes: List<String>,
    val backDropSizes: List<String>,
    val baseUrl: String): Parcelable

enum class PosterSizes {
    w92,
    w154,
    w185,
    w342,
    w500,
    w780,
    original
}

enum class BackDropSizes {
    w300,
    w780,
    w1280,
    original
}