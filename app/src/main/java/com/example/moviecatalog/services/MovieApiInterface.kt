package com.example.moviecatalog.services

import com.example.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/now_playing?api_key=30d833544c04b22ff1cb7085de58cb54")
    fun getMoviesList(): Call<MovieResponse>
}