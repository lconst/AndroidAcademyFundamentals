package com.example.androidacademyfundamentals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidacademyfundamentals.databinding.FragmentMoviesListBinding
import java.util.zip.Inflater

class FragmentMoviesList : Fragment() {

    private var listener: ClickListener? = null
    private var _fragmentBinding: FragmentMoviesListBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMoviesListBinding.bind(view)
        binding.movieItem.movie.apply {
            setOnClickListener { listener?.onClick() }
        }
    }

    override fun onDestroy() {
        _fragmentBinding = null
        super.onDestroy()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        fun newInstance(): FragmentMoviesList {
            return FragmentMoviesList()
        }
    }

    interface ClickListener {
        fun onClick()
    }
}