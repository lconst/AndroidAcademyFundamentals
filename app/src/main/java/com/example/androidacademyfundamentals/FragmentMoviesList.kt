package com.example.androidacademyfundamentals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidacademyfundamentals.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var listener: ClickListener? = null
    private var fragmentBinding: FragmentMoviesListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentMoviesListBinding.bind(view).apply {
            fragmentBinding = this

            recycler.layoutManager = GridLayoutManager(context,2)
            val spaceInPx = resources.getDimensionPixelSize(R.dimen.space_1_5x)
            recycler.addItemDecoration(RecyclerItemDecoration(2, spaceInPx))

            val adapter = MovieAdapter()
            recycler.adapter = adapter
            adapter.bindMovies(moviesList)
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
        fun newInstance(): FragmentMoviesList {
            return FragmentMoviesList()
        }
    }

    interface ClickListener {
        fun onClickItem()
    }

    private val moviesList = listOf(
        Movie(
            "Avengers: End Game",
            "Action, Adventure, Drama",
            R.drawable.movie_1,
            137,
            "13+",
            4.0f,
            125,
            listOf<Actor>(
                Actor("Robert", "Downey Jr.", R.drawable.actor_1),
                Actor("Chris", "Evans", R.drawable.actor_2),
                Actor("Mark", "Ruffalo", R.drawable.actor_3),
                Actor("Chris", "Hemsworth", R.drawable.actor_4),
            )
        ),
        Movie(
            "Tenet",
            "Action, Sci-Fi, Thriller",
            R.drawable.movie_2,
            97,
            "16+",
            5.0f,
            94,
            listOf<Actor>(
                Actor("Robert", "Downey Jr.", R.drawable.actor_1),
                Actor("Chris", "Evans", R.drawable.actor_2),
                Actor("Mark", "Ruffalo", R.drawable.actor_3),
                Actor("Chris", "Hemsworth", R.drawable.actor_4),
            )
        ),
        Movie(
            "Black Widow",
            "Action, Adventure, Sci-Fi",
            R.drawable.movie_3,
            102,
            "13+",
            4.1f,
            38,
            listOf<Actor>(
                Actor("Robert", "Downey Jr.", R.drawable.actor_1),
                Actor("Chris", "Evans", R.drawable.actor_2),
                Actor("Mark", "Ruffalo", R.drawable.actor_3),
                Actor("Chris", "Hemsworth", R.drawable.actor_4),
            )
        ),
        Movie(
            "Wonder Woman 1984",
            "Action, Adventure, Fantasy",
            R.drawable.movie_4,
            120,
            "13+",
            5.0f,
            74,
            listOf<Actor>(
                Actor("Robert", "Downey Jr.", R.drawable.actor_1),
                Actor("Chris", "Evans", R.drawable.actor_2),
                Actor("Mark", "Ruffalo", R.drawable.actor_3),
                Actor("Chris", "Hemsworth", R.drawable.actor_4),
            )
        )
    )
}