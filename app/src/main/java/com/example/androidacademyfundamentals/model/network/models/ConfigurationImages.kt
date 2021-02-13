package com.example.androidacademyfundamentals.model.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
class ConfigurationImages(

    @SerialName("poster_sizes")
    val posterSizes: List<String>,

    @SerialName("backdrop_sizes")
    val backdropSizes: List<String>,

    @SerialName("base_url")
    val baseUrl: String,

) : Parcelable