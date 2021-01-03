package com.example.androidacademyfundamentals.screen.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.data.Movie
import com.example.androidacademyfundamentals.databinding.ViewHolderMovieBinding

class MovieAdapter(
        private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var moviesList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view, listener)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        viewHolder.onBind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun bindMovies(movies: List<Movie>) {
        moviesList = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(view: View, private val clickListener: (Movie) -> Unit): RecyclerView.ViewHolder(view) {

        private val binding = ViewHolderMovieBinding.bind(itemView)

        private val roundingRadius = 16

        fun onBind(movie: Movie) {
            Glide
                .with(itemView)
                .load(movie.posterPath)
                .transform(RoundedCorners(roundingRadius))
                .into(binding.moviesImage)

            with(binding) {
                pg.text = itemView.context.getString(R.string.movies_item_age, movie.getMinimumAge())
                review.text = itemView.context.getString(R.string.review_text, movie.voteCount)
                name.text = movie.title
                //min.text = itemView.context.getString(R.string.movies_item_min, movie.overview)
                rating.rating = movie.getRating(stars = 5)
            }
            binding.root.setOnClickListener { clickListener(movie) }
        }
    }
}

