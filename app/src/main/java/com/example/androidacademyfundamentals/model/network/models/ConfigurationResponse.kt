package com.example.androidacademyfundamentals.model.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
class ConfigurationResponse(

    @SerialName("images")
    val configurationImages: ConfigurationImages,

): Parcelable
