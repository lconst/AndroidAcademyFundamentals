package com.example.androidacademyfundamentals.model.network.api

import com.example.androidacademyfundamentals.model.network.models.MovieDetailsResponse
import com.example.androidacademyfundamentals.model.network.models.NowPlayingMoviesResponse
import com.example.androidacademyfundamentals.model.network.models.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): NowPlayingMoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int) : MovieDetailsResponse
}