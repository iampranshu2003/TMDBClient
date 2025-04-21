package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.data.repository.artist.datasourceImpl.ArtistRepositoryImpl
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.data.repository.movie.datasourceImpl.MovieRepositoryImpl
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasourceImpl.TvShowRepositoryImpl
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Provides
import javax.inject.Singleton

class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}