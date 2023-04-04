package com.example.moviecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalog.models.Movie
import kotlinx.android.synthetic.main.recycler_movie_info.view.*

class MovieAdapter (
    private val movies: List<Movie>
    ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

        class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
            fun bindMovie(movie : Movie){
                itemView.tvName.text = movie.name
                Glide.with(itemView).load(IMAGE_BASE + movie.image).into(itemView.ivImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_movie_info, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
}