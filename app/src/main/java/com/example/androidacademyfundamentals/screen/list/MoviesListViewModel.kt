package com.example.androidacademyfundamentals.screen.list

import android.app.Application
import androidx.lifecycle.*
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.data.json.loadMovies
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MoviesListViewModel(application: Application): AndroidViewModel(application) {

    private val movies: LiveData<List<Movie>> = liveData {
        val data = loadMovies(getApplication())
        emit(data)
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movies
    }
}