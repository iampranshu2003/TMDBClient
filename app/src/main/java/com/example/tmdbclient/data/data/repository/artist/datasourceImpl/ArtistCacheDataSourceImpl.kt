package com.example.tmdbclient.data.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.data.model.artist.Artist
import com.example.tmdbclient.data.data.model.movie.Movie
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): ArrayList<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}