package com.example.tmdbclient.data.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.data.db.ArtistDao
import com.example.tmdbclient.data.data.db.MovieDao
import com.example.tmdbclient.data.data.model.artist.Artist
import com.example.tmdbclient.data.data.model.movie.Movie
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}