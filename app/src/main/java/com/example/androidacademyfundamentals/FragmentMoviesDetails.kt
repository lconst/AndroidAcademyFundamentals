package com.example.androidacademyfundamentals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidacademyfundamentals.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {

    private var listener: ClickListener? = null
    private var fragmentBinding: FragmentMoviesDetailsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentMoviesDetailsBinding.bind(view).apply {
            fragmentBinding = this
            back.setOnClickListener {
                listener?.onBack()
            }
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
        fun newInstance() : FragmentMoviesDetails{
            return FragmentMoviesDetails()
        }
    }

    interface ClickListener {
        fun onBack()
    }
}