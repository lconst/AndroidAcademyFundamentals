package com.example.androidacademyfundamentals.screen.list

import com.example.androidacademyfundamentals.data.Movie

interface ListFragmentInterractor {

    fun onItemClick(movie: Movie)
}