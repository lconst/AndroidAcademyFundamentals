package com.example.androidacademyfundamentals.screen.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.data.Actor
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.data.MoviesData
import com.example.androidacademyfundamentals.databinding.FragmentMoviesListBinding
import java.lang.IllegalStateException

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list){

    private lateinit var fragmentInterractor: ListFragmentInterractor
    private var fragmentBinding: FragmentMoviesListBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListFragmentInterractor) {
            fragmentInterractor = context
        } else {
            throw IllegalStateException("Activity must implement ListFragmentInterractor")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentMoviesListBinding.bind(view)
        initRecycler()
    }

    private fun initRecycler() {
        with(fragmentBinding!!) {
            recycler.layoutManager = GridLayoutManager(context,2)
            val spaceInPx = resources.getDimensionPixelSize(R.dimen.space_1x)
            recycler.addItemDecoration(RecyclerItemDecoration(2, spaceInPx))

            val adapter = MovieAdapter(::onItemClick)
            recycler.adapter = adapter
            adapter.bindMovies(MoviesData().getMovies())
        }
    }

    private fun onItemClick(movie: Movie) {
        fragmentInterractor.onItemClick(movie)
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(): FragmentMoviesList {
            return FragmentMoviesList()
        }
    }
}