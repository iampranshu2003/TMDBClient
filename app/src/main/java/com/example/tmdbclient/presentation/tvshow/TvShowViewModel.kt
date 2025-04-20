package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val updateTvShowsUsecase: UpdateTvShowsUseCase,
    private val getTvShowsUseCase: GetTvShowsUseCase
): ViewModel(){

    fun getTvShows() = liveData {
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList: List<TvShow>? = updateTvShowsUsecase.execute()
        emit(tvShowList)
    }

}