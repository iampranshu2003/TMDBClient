package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.presentation.Artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
        
    }
}