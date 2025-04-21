package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUsecase
import com.example.tmdbclient.presentation.Artist.ArtistViewModelFactory
import dagger.Provides


class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        updateArtistsUseCase: UpdateArtistsUsecase,
        getArtistsUseCase: GetArtistsUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(
            updateArtistsUseCase,
            getArtistsUseCase
        )
    }
}