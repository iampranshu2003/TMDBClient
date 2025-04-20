package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val updateTvShowsUsecase: UpdateTvShowsUseCase,
    private val getTvShowsUseCase: GetTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowViewModel::class.java)) {
            return TvShowViewModel(updateTvShowsUsecase, getTvShowsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}