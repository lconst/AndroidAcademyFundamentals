package com.example.androidacademyfundamentals

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class SecondActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE = 10
        private const val TAG = "SecondActivity"
        private const val ACTION = "com.example.broadcast.MY_NOTIFICATION"

    }
    private var broadcastReceiver: BroadcastReceiver? = null
    private val jobIntentService = ContactJobIntentService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(ACTION)
        }
        broadcastReceiver = makeBroadcastReceiver()

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver!!, filter)

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, Array(1) { android.Manifest.permission.READ_CONTACTS }, REQUEST_CODE)
        } else {
            readContact()
        }
    }

    private fun makeBroadcastReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {
                Log.d(TAG, "onReceive: yo-ho!!!")
                startFirstActivity(intent)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 10 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            readContact()
        } else {
            Toast.makeText(this, "You need allow reading contacts", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readContact() {
        jobIntentService.enqueueWork(this, Intent(this, ContactJobIntentService::class.java));
    }

    private fun startFirstActivity(inputIntent: Intent?) {
        setResult(RESULT_OK, inputIntent);
        finish();
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver!!)
        super.onDestroy()
    }

}