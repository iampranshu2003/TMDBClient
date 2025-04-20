package com.example.tmdbclient.presentation.Artist

import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUsecase

class ArtistViewModelFactory(
    private val updateArtistsUsecase: UpdateArtistsUsecase,
    private val getArtistsUseCase: GetArtistsUseCase
): ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            return ArtistViewModel(updateArtistsUsecase, getArtistsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}