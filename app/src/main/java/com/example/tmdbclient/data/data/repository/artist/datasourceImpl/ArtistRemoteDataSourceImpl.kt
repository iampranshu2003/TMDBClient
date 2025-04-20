package com.example.tmdbclient.data.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.data.api.TMDBService
import com.example.tmdbclient.data.data.model.artist.ArtistList
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)

    }
}