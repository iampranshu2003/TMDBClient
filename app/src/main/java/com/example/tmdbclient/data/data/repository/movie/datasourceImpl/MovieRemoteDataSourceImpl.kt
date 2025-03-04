package com.example.tmdbclient.data.data.repository.movie.datasourceImpl

import com.example.tmdbclient.data.data.api.TMDBService
import com.example.tmdbclient.data.data.model.movie.MovieList
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}