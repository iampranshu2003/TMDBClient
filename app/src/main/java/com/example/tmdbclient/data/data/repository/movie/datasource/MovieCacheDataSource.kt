package com.example.tmdbclient.data.data.repository.movie.datasource

import com.example.tmdbclient.data.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}