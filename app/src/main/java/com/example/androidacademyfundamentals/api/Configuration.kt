package com.example.androidacademyfundamentals.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

@Parcelize
@Serializable
class Configuration(

	@SerialName("images")
	val images: Images,

	@SerialName("change_keys")
	val changeKeys: List<String>
) : Parcelable

@Parcelize
@Serializable
class Images(

	@SerialName("poster_sizes")
	val posterSizes: List<String>,

	@SerialName("secure_base_url")
	val secureBaseUrl: String,

	@SerialName("backdrop_sizes")
	val backdropSizes: List<String>,

	@SerialName("base_url")
	val baseUrl: String,

	@SerialName("logo_sizes")
	val logoSizes: List<String>,

	@SerialName("still_sizes")
	val stillSizes: List<String>,

	@SerialName("profile_sizes")
	val profileSizes: List<String>
) : Parcelable

interface ConfigurationApi {
	@GET("configuration")
	suspend fun getConfiguration(): Configuration
}
