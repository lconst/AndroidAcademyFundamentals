package com.example.androidacademyfundamentals.data

import com.example.androidacademyfundamentals.R

class MoviesData {
    private val moviesList = listOf(
            Movie(
                    "Avengers: End Game",
                    "Action, Adventure, Drama",
                    R.drawable.movie_1,
                    137,
                    "13+",
                    4.0f,
                    125,
                    listOf(
                            Actor(
                                    "Robert",
                                    "Downey Jr.",
                                    R.drawable.actor_1
                            ),
                            Actor(
                                    "Chris",
                                    "Evans",
                                    R.drawable.actor_2
                            ),
                            Actor(
                                    "Mark",
                                    "Ruffalo",
                                    R.drawable.actor_3
                            ),
                            Actor(
                                    "Chris",
                                    "Hemsworth",
                                    R.drawable.actor_4
                            ),
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
                    listOf(
                            Actor(
                                    "Robert",
                                    "Downey Jr.",
                                    R.drawable.actor_1
                            ),
                            Actor(
                                    "Chris",
                                    "Evans",
                                    R.drawable.actor_2
                            ),
                            Actor(
                                    "Mark",
                                    "Ruffalo",
                                    R.drawable.actor_3
                            ),
                            Actor(
                                    "Chris",
                                    "Hemsworth",
                                    R.drawable.actor_4
                            ),
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
                    listOf(
                            Actor(
                                    "Robert",
                                    "Downey Jr.",
                                    R.drawable.actor_1
                            ),
                            Actor(
                                    "Chris",
                                    "Evans",
                                    R.drawable.actor_2
                            ),
                            Actor(
                                    "Mark",
                                    "Ruffalo",
                                    R.drawable.actor_3
                            ),
                            Actor(
                                    "Chris",
                                    "Hemsworth",
                                    R.drawable.actor_4
                            ),
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
                    listOf(
                            Actor(
                                    "Robert",
                                    "Downey Jr.",
                                    R.drawable.actor_1
                            ),
                            Actor(
                                    "Chris",
                                    "Evans",
                                    R.drawable.actor_2
                            ),
                            Actor(
                                    "Mark",
                                    "Ruffalo",
                                    R.drawable.actor_3
                            ),
                            Actor(
                                    "Chris",
                                    "Hemsworth",
                                    R.drawable.actor_4
                            ),
                    )
            )
    )

    fun getMovies() = moviesList
}