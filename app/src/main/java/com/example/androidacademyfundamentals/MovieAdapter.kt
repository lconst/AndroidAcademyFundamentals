package com.example.androidacademyfundamentals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    private var moviesList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.onBind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun bindMovies(movies: List<Movie>) {
        moviesList = movies
        notifyDataSetChanged()
    }

    class MovieHolder(view: View): RecyclerView.ViewHolder(view) {

        private val image: ImageView? = view.findViewById(R.id.movies_image)
        private val pg: TextView? = view.findViewById(R.id.pg)
        private val tag: TextView? = view.findViewById(R.id.tag)
        private val ratingBar: RatingBar? = view.findViewById(R.id.rating)
        private val review: TextView? = view.findViewById(R.id.review)
        private val name: TextView? = view.findViewById(R.id.name)
        private val min: TextView? = view.findViewById(R.id.min)

        fun onBind(movie: Movie) {
            image?.setImageResource(movie.imageId)
            pg?.text = movie.pg
            tag?.text = movie.tag
            ratingBar?.rating = movie.rating
            review?.setText( R.string.review_text, movie.review)
        }

    }
}

