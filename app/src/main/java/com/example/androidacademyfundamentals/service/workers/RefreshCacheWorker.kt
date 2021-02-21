package com.example.androidacademyfundamentals.service.workers

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.concurrent.futures.CallbackToFutureAdapter
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.example.androidacademyfundamentals.MovieApp
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RefreshCacheWorker(
    val context: Context,
    params: WorkerParameters
) : ListenableWorker(context, params) {

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private val connManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun startWork(): ListenableFuture<Result> {

        val builder: NetworkRequest.Builder = NetworkRequest.Builder()

        return CallbackToFutureAdapter.getFuture { completer ->
            val callback = connManager.registerNetworkCallback(
                builder.build(),
                object : ConnectivityManager.NetworkCallback() {

                    override fun onAvailable(network: Network) {
                        val networkCapabilities = connManager.getNetworkCapabilities(network)
                        networkCapabilities?.let {
                            if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                                coroutineScope.launch {
                                    MovieApp.appComponent.movieDataSource.refreshData()
                                    completer.set(Result.success())
                                    Log.d(TAG, "Success")
                                }
                            } else {
                                completer.set(Result.failure())
                                Log.d(TAG, "fail")
                            }
                        }
                    }

                    override fun onLost(network: Network) {
                        completer.set(Result.failure())
                        Log.d(TAG, "fail")
                    }
                })

            callback
        }
    }

    companion object {
        private val TAG = RefreshCacheWorker::class.java.simpleName
    }
}