package com.example.androidacademyfundamentals.screen.list

import com.example.androidacademyfundamentals.data.Movie

interface ListFragmentInteractor {

    fun onItemClick(movie: Movie)
}