package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.data.api.TMDBService
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService,): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )

    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService,): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )

    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService,): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )

    }
}