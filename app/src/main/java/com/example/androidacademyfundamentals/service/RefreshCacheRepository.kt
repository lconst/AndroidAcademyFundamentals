package com.example.androidacademyfundamentals.service

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import com.example.androidacademyfundamentals.service.workers.RefreshCacheWorker
import java.util.concurrent.TimeUnit

class RefreshCacheRepository {

    private val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

    val requestMovies = PeriodicWorkRequestBuilder<RefreshCacheWorker>(INTERVAL, TimeUnit.HOURS)
        .setConstraints(constraints)
        .build()

    companion object {
        private const val INTERVAL = 8L
    }
}

