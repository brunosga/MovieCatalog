package com.example.moviecatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalog.models.Movie
import com.example.moviecatalog.models.MovieResponse
import com.example.moviecatalog.services.MovieApiInterface
import com.example.moviecatalog.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovie.layoutManager = LinearLayoutManager(this)
        rvMovie.setHasFixedSize(true)
        getMoviesData { movies : List<Movie> ->
            rvMovie.adapter = MovieAdapter(movies)
        }
    }

    private fun getMoviesData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMoviesList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }
}