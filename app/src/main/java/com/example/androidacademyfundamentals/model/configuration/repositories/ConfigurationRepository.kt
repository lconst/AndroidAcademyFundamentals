package com.example.androidacademyfundamentals.model.configuration.repositories

import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.model.configuration.network.ConfigurationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Configuration]
 */
class ConfigurationRepository(private val configurationApi: ConfigurationApi) {

    /**
     * get [Configuration]
     */
    suspend fun getConfiguration(): Configuration {
        val configurationResponse = withContext(Dispatchers.IO) {
            configurationApi.getConfiguration()
        }
        return Configuration(
            configurationResponse.configurationImages.posterSizes,
            configurationResponse.configurationImages.backdropSizes,
            configurationResponse.configurationImages.baseUrl
        )
    }
}