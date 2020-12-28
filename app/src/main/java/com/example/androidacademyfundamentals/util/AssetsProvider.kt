package com.example.androidacademyfundamentals.util

import android.content.Context

interface AssetsProvider {
    fun readDataFromAssets(fileName: String): String
}

class  AssetsProviderImp(private val context: Context) : AssetsProvider {

    override fun readDataFromAssets(fileName: String): String = context.assets.open(fileName).bufferedReader().readText()
}