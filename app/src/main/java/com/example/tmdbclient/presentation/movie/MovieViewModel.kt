package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.data.model.movie.Movie
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    private val updateMoviesUsecase: UpdateMoviesUsecase,
    private val getMoviesUseCase: GetMoviesUseCase
):ViewModel() {

    fun getMovies() = liveData {
        val movieList:List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }
}