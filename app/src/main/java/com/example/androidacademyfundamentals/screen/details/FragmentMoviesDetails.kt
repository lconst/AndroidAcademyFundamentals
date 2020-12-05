package com.example.androidacademyfundamentals.screen.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {

    private var listener: ClickListener? = null
    private var fragmentBinding: FragmentMoviesDetailsBinding? = null
    private var movie: Movie? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener) {
            listener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            movie = args.get(MOVIE_KEY) as Movie
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            movie = savedInstanceState.getParcelable(MOVIE_KEY)
        }

        FragmentMoviesDetailsBinding.bind(view).apply {
            fragmentBinding = this
            back.setOnClickListener {
                listener?.onBack()
            }
            recycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false)
            val adapter = ActorAdapter()
                adapter.bindActors(movie!!.actors)
            recycler.adapter = adapter

            name?.text = movie!!.name
            pg?.text = movie!!.pg
            tag.text = movie!!.tag
            rating.rating = movie!!.rating
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(MOVIE_KEY, movie)
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    companion object {
        fun newInstance(movie: Movie) : FragmentMoviesDetails {
            val fragment =
                FragmentMoviesDetails()
            val args = Bundle()
            args.putParcelable(MOVIE_KEY, movie)
            fragment.arguments = args
            return fragment
        }

        const val MOVIE_KEY = "movie"
    }

    interface ClickListener {
        fun onBack()
    }
}