package com.example.androidacademyfundamentals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidacademyfundamentals.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var listener: ClickListener? = null
    private var fragmentBinding: FragmentMoviesListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentMoviesListBinding.bind(view).apply {
            fragmentBinding = this
            movieItem.movie.setOnClickListener { listener?.onClickItem() }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener) {
            listener = context
        }
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
        fun newInstance(): FragmentMoviesList {
            return FragmentMoviesList()
        }
    }

    interface ClickListener {
        fun onClickItem()
    }
}