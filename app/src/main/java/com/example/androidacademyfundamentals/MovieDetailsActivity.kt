package com.example.androidacademyfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, FragmentMoviesDetails.newInstance())
                .commit()
    }
}