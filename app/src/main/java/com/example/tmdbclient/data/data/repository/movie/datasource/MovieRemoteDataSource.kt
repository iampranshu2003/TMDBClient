package com.example.tmdbclient.data.data.repository.movie.datasource


import com.example.tmdbclient.data.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}