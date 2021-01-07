package com.example.androidacademyfundamentals.screen.details

import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.databinding.FragmentMoviesDetailsBinding
import java.lang.IllegalStateException

class MoviesDetailsFragment : Fragment(R.layout.fragment_movies_details) {

    private lateinit var listener: DetailsFragmentInterractor
    private var fragmentBinding: FragmentMoviesDetailsBinding? = null
    private val movieId: Int by lazy { requireArguments().getInt(MOVIE_ID) }

    private val viewModel: MoviesDetailsViewModel by viewModels {
        MoviesDetailsViewModelFactory(movieId)
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

        setViews()
        initRecycler()
    }

    private fun setViews() {
//        Glide
//            .with(requireContext())
//            .load(movie.backdrop)
//            .into(fragmentBinding!!.backdoor)
//
//        with(fragmentBinding?:return) {
//            backdoor.colorFilter = ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f)})
//            back.setOnClickListener { listener.onBack() }
//            name.text = movie.title
//            pg.text = requireContext().getString(R.string.movies_item_age, movie.minimumAge)
//            tag.text = movie.genres.joinToString { it.name }
//            rating.rating = movie.getRating()
//            storylineText.text = movie.overview
//        }
    }

    private fun initRecycler() {
//        val actorAdapter = ActorAdapter()
//        actorAdapter.bindActors(movie.actors)
//        with(fragmentBinding!!.recycler) {
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            adapter = actorAdapter
//        }
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(movieId: Int): Fragment = MoviesDetailsFragment().apply {
            arguments = bundleOf(MOVIE_ID to movieId)
        }

        const val MOVIE_ID = "movieId"
    }
}