package com.example.tmdbclient.presentation.di

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.AppComponent
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.NetModule
import com.example.tmdbclient.presentation.di.core.RemoteDataModule
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }
}