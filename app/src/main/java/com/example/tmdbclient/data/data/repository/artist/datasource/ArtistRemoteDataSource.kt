package com.example.tmdbclient.data.data.repository.artist.datasource

import com.example.tmdbclient.data.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}