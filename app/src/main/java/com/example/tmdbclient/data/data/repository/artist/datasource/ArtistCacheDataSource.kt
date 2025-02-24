package com.example.tmdbclient.data.data.repository.artist.datasource

import com.example.tmdbclient.data.data.model.artist.Artist
import com.example.tmdbclient.data.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artist :List<Artist>)
}