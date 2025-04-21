package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase
import dagger.Provides

class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)

    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)

    }

    @Provides
    fun provideGetTvShowUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)

    }

    @Provides
    fun provideUpdateTvShowUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)

    }

    @Provides
    fun provideGetArtistUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)

    }

    @Provides
    fun provideUpdateArtistUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)

    }


}