package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.presentation.Artist.ArtistActivity
import com.example.tmdbclient.presentation.di.artist.ArtistModule
import com.example.tmdbclient.presentation.di.artist.ArtistScope
import com.example.tmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
        
    }
}