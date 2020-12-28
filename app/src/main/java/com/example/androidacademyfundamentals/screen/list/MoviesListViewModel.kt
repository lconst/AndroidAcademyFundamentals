package com.example.androidacademyfundamentals.screen.list

import androidx.lifecycle.*
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.data.json.loadMovies
import com.example.androidacademyfundamentals.util.AssetsProvider
import kotlinx.coroutines.launch

class MoviesListViewModel(private val assertsProvider: AssetsProvider): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>(emptyList())
    val movies: LiveData<List<Movie>> get() = _movies

    fun loadMovies() {
        viewModelScope.launch {
            _movies.value = loadMovies(assertsProvider)
        }
    }
}