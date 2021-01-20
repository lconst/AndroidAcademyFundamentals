package com.example.androidacademyfundamentals.presentation.movies.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidacademyfundamentals.ListFragmentInteractor
import com.example.androidacademyfundamentals.MovieApp
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.databinding.FragmentMoviesListBinding
import com.example.androidacademyfundamentals.model.configuration.entities.Configuration
import com.example.androidacademyfundamentals.presentation.movies.viewmodel.MoviesListViewModel
import com.example.androidacademyfundamentals.presentation.movies.viewmodel.MoviesListViewModelFactory
import java.lang.IllegalStateException

class MoviesListFragment : Fragment(R.layout.fragment_movies_list){

    private lateinit var fragmentInteractor: ListFragmentInteractor

    private var fragmentBinding: FragmentMoviesListBinding? = null

    private val config: Configuration by lazy {
        requireArguments().get(CONFIG) as Configuration
    }

    private val viewModel: MoviesListViewModel by viewModels {
        MoviesListViewModelFactory((requireActivity().application as MovieApp).moviesRepo, config)
    }

    private val adapter = MovieAdapter(::onItemClick)

    private val numberOfColumns = 2

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

        viewModel.loadMovies()
        viewModel.movies.observe(this.viewLifecycleOwner) {
            adapter.bindMovies(it)
        }
    }

    private fun initRecycler() {
        with(fragmentBinding?:return) {
            recycler.layoutManager = GridLayoutManager(context, numberOfColumns)
            recycler.adapter = adapter

            val spaceInPx = resources.getDimensionPixelSize(R.dimen.space_1x)
            recycler.addItemDecoration(RecyclerItemDecoration(numberOfColumns, spaceInPx))
        }
    }

    private fun onItemClick(movieId: Int) {
        fragmentInteractor.onItemClick(movieId)
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(config: Configuration): Fragment = MoviesListFragment().apply {
            arguments = bundleOf(CONFIG to config )
        }

        const val CONFIG = "config"
    }

}