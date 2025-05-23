package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
//    fun createTvShowDetailsSubComponent(): TvShowDetailsSubComponent
//    fun createMovieDetailsSubComponent(): MovieDetailsSubComponent
//    fun createArtistDetailsSubComponent(): ArtistDetailsSubComponent
}