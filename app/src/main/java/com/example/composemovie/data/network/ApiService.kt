package com.example.composemovie.data.network

import com.example.composemovie.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows")
    suspend fun getAllMovies() :Response<List<Movies>>
}