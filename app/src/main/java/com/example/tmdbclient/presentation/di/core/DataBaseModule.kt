package com.example.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.data.db.ArtistDao
import com.example.tmdbclient.data.data.db.MovieDao
import com.example.tmdbclient.data.data.db.TMDBDatabase
import com.example.tmdbclient.data.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdbclient"
        ).build()
        // Provide the database instance here
    }

    @Singleton
    @Provides
    fun ProvideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
        // Provide the DAO instance here
    }


//    @Singleton
//    @Provides
//    fun ProvideArtistDatabase(context: Context): TMDBDatabase {
//        return Room.databaseBuilder(
//            context,
//            TMDBDatabase::class.java,
//            "tmdbclient"
//        ).build()
//    }

    @Singleton
    @Provides
    fun ProvideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
        // Provide the DAO instance here
    }

    @Singleton
    @Provides
    fun ProvideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
        // Provide the DAO instance here
    }



}