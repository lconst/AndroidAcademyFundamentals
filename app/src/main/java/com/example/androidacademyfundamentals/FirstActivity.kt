package com.example.androidacademyfundamentals

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class FirstActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "FirstActivity"
    }

    private var contacts = mutableListOf<String>()
    private val adapter: ArrayAdapter<String> by lazy {
        ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, contacts
        ) }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
            contacts.addAll(intent?.getStringArrayListExtra("contacts")!!.toMutableList())
            adapter.notifyDataSetChanged();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val listView = findViewById<ListView>(R.id.list)

        listView.setAdapter(adapter)

        val startButton: Button = findViewById(R.id.start)

        startButton.setOnClickListener {
            contacts.clear()
            startForResult.launch(SecondActivity.startActivity(this))
        }
    }

}