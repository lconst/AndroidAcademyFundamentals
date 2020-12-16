package com.example.androidacademyfundamentals.util

import android.content.Context

fun readAssetFileToString(context: Context, fileName: String): String {
    val stream = context.assets.open(fileName)
    return stream.bufferedReader().readText()
}