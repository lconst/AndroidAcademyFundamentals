package com.example.androidacademyfundamentals.screen.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
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

    class MovieViewHolder(itemView: View, private val clickListener: (Movie) -> Unit): RecyclerView.ViewHolder(itemView) {

//        private val image: ImageView = view.findViewById(R.id.movies_image)
//        private val pg: TextView = view.findViewById(R.id.pg)
//        private val tag: TextView = view.findViewById(R.id.tag)
//        private val ratingBar: RatingBar = view.findViewById(R.id.rating)
//        private val review: TextView = view.findViewById(R.id.review)
//        private val name: TextView = view.findViewById(R.id.name)
//        private val min: TextView = view.findViewById(R.id.min)
        private val binding = ViewHolderMovieBinding.bind(itemView)

        fun onBind(movie: Movie) {
            with(binding) {
                pg.text = movie.pg
                tag.text = movie.tag
                review.text = itemView.context.getString(R.string.review_text, movie.review)
                name.text = movie.name
                min.text = itemView.context.getString(R.string.movies_item_min, movie.minutes)
                moviesImage.setImageResource(movie.imageId)
                rating.rating = movie.rating
            }
            binding.root.setOnClickListener { clickListener(movie) }
        }
    }
}

