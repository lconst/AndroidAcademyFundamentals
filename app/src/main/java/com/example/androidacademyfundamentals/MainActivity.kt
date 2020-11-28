package com.example.androidacademyfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentMoviesList.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToList()
    }

    override fun onClick() {
        navigateToDetails()
    }

    private fun navigateToDetails() {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, FragmentMoviesDetails.newInstance())
                .commit()
    }

    private fun navigateToList() {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, FragmentMoviesList.newInstance())
                .commit()
    }
}