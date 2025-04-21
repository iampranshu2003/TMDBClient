package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.data.db.ArtistDao
import com.example.tmdbclient.data.data.db.MovieDao
import com.example.tmdbclient.data.data.db.TvShowDao
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Provides
import javax.inject.Singleton

class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}