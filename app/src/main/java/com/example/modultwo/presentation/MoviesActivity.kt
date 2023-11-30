package com.example.modultwo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modultwo.R
import com.example.modultwo.databinding.ActivityMoviesBinding

class MoviesActivity : AppCompatActivity() {

    private lateinit var movies: ActivityMoviesBinding
    private var list = listOf(
        Movie(R.drawable.witcher),
        Movie(R.drawable.jessicajones),
        Movie(R.drawable.magicians)
    )
    private val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movies = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(movies.root)

        movies.Movies.layoutManager = LinearLayoutManager(this@MoviesActivity)
        movies.Movies.adapter = adapter
        adapter.addMovieList(list)
    }
}