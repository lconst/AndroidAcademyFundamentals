package com.example.androidacademyfundamentals.presentation.details.view

import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.databinding.FragmentMoviesDetailsBinding
import com.example.androidacademyfundamentals.DetailsFragmentInterractor
import com.example.androidacademyfundamentals.MovieApp
import com.example.androidacademyfundamentals.model.configuration.entities.BackDropSizes
import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.model.movies.entities.Movie
import com.example.androidacademyfundamentals.presentation.details.viewmodel.MoviesDetailsViewModel
import com.example.androidacademyfundamentals.presentation.details.viewmodel.MoviesDetailsViewModelFactory
import java.lang.IllegalStateException

class MoviesDetailsFragment : Fragment(R.layout.fragment_movies_details) {

    private lateinit var listener: DetailsFragmentInterractor
    private var fragmentBinding: FragmentMoviesDetailsBinding? = null
    private val movieId: Int by lazy { requireArguments().getInt(MOVIE_ID) }

    private val config: Configuration by lazy { requireArguments().get(CONFIG) as Configuration }

    private val viewModel: MoviesDetailsViewModel by viewModels {
        MoviesDetailsViewModelFactory(movieId, (requireActivity().application as MovieApp).moviesRepo)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DetailsFragmentInterractor) {
            listener = context
        } else {
            throw IllegalStateException("Activity must implement DetailsFragmentInterractor")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentMoviesDetailsBinding.bind(view)

        viewModel.movieDetails.observe(this.viewLifecycleOwner) {
            setViews(it)
        }
        viewModel.loadMovieDetails()
    }

    private fun setViews(movieDetails: Movie) {

        val baseUrl = config.baseUrl
        val size = config.backDropSizes[BackDropSizes.w780.ordinal]

        Glide
            .with(requireContext())
            .load(baseUrl + size + movieDetails.backdropPath)
            .into(fragmentBinding!!.backdoor)

        with(fragmentBinding?:return) {
            backdoor.colorFilter = ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f)})
            back.setOnClickListener { listener.onBack() }
            name.text = movieDetails.title
            pg.text = requireContext().getString(R.string.movies_item_age, movieDetails.getMinimumAge())
            tag.text = movieDetails.genre?.joinToString { it.name }
            rating.rating = movieDetails.getRating()
            review.text = movieDetails.voteCount.toString()
            storylineText.text = movieDetails.overview
        }
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(movieId: Int, config: Configuration): Fragment = MoviesDetailsFragment().apply {
            arguments = bundleOf(
                    MOVIE_ID to movieId,
                    CONFIG to config
            )
        }

        const val MOVIE_ID = "movieId"
        const val CONFIG = "config"
    }
}