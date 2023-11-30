package com.example.modultwo.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modultwo.R
import com.example.modultwo.databinding.ChatBinding
import com.example.modultwo.databinding.MovieBinding

class MovieAdapter :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    val movieList = ArrayList<Movie>()

    class MovieHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = MovieBinding.bind(item)
        fun bind(movie: Movie) = with(binding) {
            MovieBackground.setImageResource(movie.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun addMovieList(list: List<Movie>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }
}