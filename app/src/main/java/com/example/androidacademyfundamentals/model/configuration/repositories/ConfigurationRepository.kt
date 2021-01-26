package com.example.androidacademyfundamentals.model.configuration.repositories

import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.model.configuration.network.ConfigurationApi
import com.example.androidacademyfundamentals.utils.SingletonHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Configuration]
 */
class ConfigurationRepository private constructor(private val configurationApi: ConfigurationApi) {

    private var config: Configuration? = null

    /**
     * get [Configuration]
     */
    suspend fun getConfiguration(): Configuration {
        if (config == null) {
            val configurationResponse = withContext(Dispatchers.IO) {
                configurationApi.getConfiguration()
            }
            config = Configuration(
                    configurationResponse.configurationImages.posterSizes,
                    configurationResponse.configurationImages.backdropSizes,
                    configurationResponse.configurationImages.baseUrl
            )
        }
        return config as Configuration
    }

    companion object : SingletonHolder<ConfigurationRepository, ConfigurationApi>(::ConfigurationRepository)
}