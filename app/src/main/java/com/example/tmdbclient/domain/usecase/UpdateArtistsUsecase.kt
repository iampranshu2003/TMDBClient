package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.data.model.artist.Artist
import com.example.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}