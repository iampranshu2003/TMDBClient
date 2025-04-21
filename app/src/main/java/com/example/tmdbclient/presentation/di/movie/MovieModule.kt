package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUsecase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.example.tmdbclient.presentation.Artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.di.artist.ArtistScope
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Provides


class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        updateMoviesUseCase: UpdateMoviesUsecase,
        getMoviesUseCase: GetMoviesUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(
            updateMoviesUseCase,
            getMoviesUseCase
        )
    }
}