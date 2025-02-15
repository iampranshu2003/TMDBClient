package com.example.tmdbclient.domain

import com.example.tmdbclient.data.data.model.movie.Movie

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun updateMovies():List<Movie>? = movieRepository.updateMovies()
    
}