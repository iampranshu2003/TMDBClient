package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.CacheDataModule
import com.example.tmdbclient.presentation.di.core.DataBaseModule
import com.example.tmdbclient.presentation.di.core.LocalDataModule
import com.example.tmdbclient.presentation.di.core.NetModule
import com.example.tmdbclient.presentation.di.core.RemoteDataModule
import com.example.tmdbclient.presentation.di.core.RepositoryModule
import com.example.tmdbclient.presentation.di.core.UseCaseModule
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, CacheDataModule::class, UseCaseModule::class, RepositoryModule::class, LocalDataModule::class, RemoteDataModule::class, DataBaseModule::class])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}