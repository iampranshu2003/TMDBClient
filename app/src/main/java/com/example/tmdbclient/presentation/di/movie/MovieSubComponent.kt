package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.presentation.Artist.ArtistActivity
import com.example.tmdbclient.presentation.di.artist.ArtistModule
import com.example.tmdbclient.presentation.di.artist.ArtistScope
import com.example.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
        
    }
}