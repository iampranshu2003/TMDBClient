package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUsecase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbclient.presentation.Artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.di.artist.ArtistScope
import com.example.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Provides


class TvShowModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        updateTvShowsUseCase: UpdateTvShowsUseCase,
        getTvShowsUseCase: GetTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(
            updateTvShowsUseCase,
            getTvShowsUseCase
        )
    }
}