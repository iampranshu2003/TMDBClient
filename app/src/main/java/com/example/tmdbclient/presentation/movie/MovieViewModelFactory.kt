package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase

class MovieViewModelFactory(
    private val updateMoviesUsecase: UpdateMoviesUsecase,
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(updateMoviesUsecase, getMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}