package com.example.androidacademyfundamentals.data.json

import com.example.androidacademyfundamentals.data.Genre
import com.example.androidacademyfundamentals.util.AssetsProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
private class JsonGenre(val id: Int, val name: String)

private val jsonFormat = Json { ignoreUnknownKeys = true }

internal suspend fun loadGenres(assetsProvider: AssetsProvider): List<Genre> = withContext(Dispatchers.IO) {
    val data = assetsProvider.readDataFromAssets("genres.json")
    parseGenres(data)
}

internal fun parseGenres(data: String): List<Genre> {
    val jsonGenres = jsonFormat.decodeFromString<List<JsonGenre>>(data)
    return jsonGenres.map { Genre(id = it.id, name = it.name) }
}