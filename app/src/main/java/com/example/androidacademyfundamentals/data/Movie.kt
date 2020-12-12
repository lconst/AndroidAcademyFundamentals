package com.example.androidacademyfundamentals.data

import android.os.Parcelable
import com.example.androidacademyfundamentals.data.Actor
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Movie(
    val name: String,
    val tag: String,
    val imageId: Int,
    val minutes: Int,
    val pg: String,
    val rating: Float,
    val review: Int,
    val actors: @RawValue List<Actor>
): Parcelable