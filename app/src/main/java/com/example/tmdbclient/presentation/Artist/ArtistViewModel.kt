package com.example.tmdbclient.presentation.Artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.data.model.artist.Artist
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUsecase

class ArtistViewModel(
    private val updateArtistsUsecase: UpdateArtistsUsecase,
    private val getArtistsUseCase: GetArtistsUseCase
): ViewModel()  {
    fun getArtists() = liveData {
        val artistList : List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList : List<Artist>? = updateArtistsUsecase.execute()
        emit(artistList)
    }
}