package com.example.androidacademyfundamentals.data.json

import com.example.androidacademyfundamentals.data.Actor
import com.example.androidacademyfundamentals.util.AssetsProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val jsonFormat = Json { ignoreUnknownKeys = true }

@Serializable
private class JsonActor(
    val id: Int,
    val name: String,
    @SerialName("profile_path")
    val profilePicture: String
)

suspend fun loadActors(assetsProvider: AssetsProvider): List<Actor> = withContext(Dispatchers.IO) {
    val data = assetsProvider.readDataFromAssets("people.json")
    parseActors(data)
}

internal fun parseActors(data: String): List<Actor> {
    val jsonActors = jsonFormat.decodeFromString<List<JsonActor>>(data)
    return jsonActors.map { Actor(id = it.id, name = it.name, picture = it.profilePicture) }
}