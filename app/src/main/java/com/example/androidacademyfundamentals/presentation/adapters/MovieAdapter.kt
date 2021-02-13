package com.example.androidacademyfundamentals.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.databinding.ViewHolderMovieBinding
import com.example.androidacademyfundamentals.model.models.Movie

class MovieAdapter(
        private val listener: (Int) -> Unit
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

    class MovieViewHolder(view: View, private val clickListener: (Int) -> Unit): RecyclerView.ViewHolder(view) {

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
                rating.rating = movie.getRating()
            }
            binding.root.setOnClickListener { clickListener(movie.id) }
        }
    }
}

