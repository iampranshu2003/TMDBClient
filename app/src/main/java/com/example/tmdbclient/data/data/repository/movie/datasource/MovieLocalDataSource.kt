package com.example.tmdbclient.data.data.repository.movie.datasource

import com.example.tmdbclient.data.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()

}