package com.example.androidacademyfundamentals

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.ContactsContract
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.JobIntentService
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class ContactJobIntentService: JobIntentService() {

    companion object {
        private val TAG = "MyJobIntentService"
    }

    private var cols = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
    )

    private val contacts = arrayListOf<String>()

    fun enqueueWork(context: Context, work: Intent) {
        enqueueWork(context, ContactJobIntentService::class.java, 123, work)
    }

    override fun onDestroy() {
        Intent().also { intent ->
            intent.setAction("com.example.broadcast.MY_NOTIFICATION")
            intent.putExtra("contacts", contacts)
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }

        super.onDestroy()
        Log.d(TAG, "onDestroy: $TAG")
    }

    override fun onHandleWork(intent: Intent) {

        val rs = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
        if (rs == null) {
            Log.e(TAG, "onHandleWork: rs == null" )
        } else if (!rs.moveToNext()) {
            contacts.add(getString(R.string.contacts_not_found))
        } else {
             do {
                contacts.add("${rs.getString(0)} ${rs.getString(1)}")
            } while (rs.moveToNext())
        }
    }
}