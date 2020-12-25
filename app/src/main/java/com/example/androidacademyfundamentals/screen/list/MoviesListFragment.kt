package com.example.androidacademyfundamentals.screen.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.data.json.loadMovies
import com.example.androidacademyfundamentals.databinding.FragmentMoviesListBinding
import kotlinx.coroutines.*
import java.lang.IllegalStateException

class MoviesListFragment : Fragment(R.layout.fragment_movies_list){

    private lateinit var fragmentInteractor: ListFragmentInteractor

    private var fragmentBinding: FragmentMoviesListBinding? = null

    private val viewModel: MoviesListViewModel by viewModels {
        MoviesListViewModelFactory(requireActivity().application)
    }

    private val adapter = MovieAdapter(::onItemClick)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListFragmentInteractor) {
            fragmentInteractor = context
        } else {
            throw IllegalStateException("Activity must implement ListFragmentInteractor")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentMoviesListBinding.bind(view)

        initRecycler()

        viewModel.getMovies().observe(this.viewLifecycleOwner) {
            adapter.bindMovies(it)
        }
    }

    private fun initRecycler() {
        with(fragmentBinding?:return) {
            recycler.layoutManager = GridLayoutManager(context,2)
            recycler.adapter = adapter

            val spaceInPx = resources.getDimensionPixelSize(R.dimen.space_1x)
            recycler.addItemDecoration(RecyclerItemDecoration(2, spaceInPx))
        }
    }

    private fun onItemClick(movie: Movie) {
        fragmentInteractor.onItemClick(movie)
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(): MoviesListFragment {
            return MoviesListFragment()
        }
    }
}