package com.example.androidacademyfundamentals

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), FragmentMoviesList.ClickListener,
    FragmentMoviesDetails.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToFragment(
                FragmentMoviesList.newInstance(),
                FragmentMoviesList.FRAGMENT_TAG
            )
        }
    }

    // listener of fragment movies list
    override fun onClickItem() {
        navigateToFragment(
            FragmentMoviesDetails.newInstance(),
            FragmentMoviesDetails.FRAGMENT_TAG
        )
    }

    // listener of fragment details list
    override fun onBack() {
        onBackPressed()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        supportFragmentManager.putFragment(
            outState,
            FRAGMENT_KEY,
            supportFragmentManager.fragments.last()
        )
    }

    private fun navigateToFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .addToBackStack(tag)
            .commit()
    }

    companion object {
        val FRAGMENT_KEY = "fragmentKey"
    }
}