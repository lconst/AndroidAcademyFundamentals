package com.example.androidacademyfundamentals.presentation.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidacademyfundamentals.*
import com.example.androidacademyfundamentals.model.models.Configuration
import com.example.androidacademyfundamentals.presentation.viewmodel.MainActivityViewModel
import com.example.androidacademyfundamentals.presentation.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity(), ListFragmentInteractor, DetailsFragmentInterractor {

    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModelFactory((application as MovieApp).networkModule.configurationRepo)
    }
    private lateinit var config: Configuration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.config.observe(this) {
            config = it
            if (savedInstanceState == null) {
                navigateToFragment(MoviesListFragment.newInstance(it), MoviesListFragment::class.java.name)
            }
        }
        viewModel.loadConfig()
    }

    override fun onItemClick(movieId: Int) {
        navigateToFragment(
                MoviesDetailsFragment.newInstance(movieId, config),
                MoviesDetailsFragment::class.java.name
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
        private const val FRAGMENT_KEY = "fragmentKey"
    }
}