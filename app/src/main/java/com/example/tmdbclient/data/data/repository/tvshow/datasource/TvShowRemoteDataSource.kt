package com.example.tmdbclient.data.data.repository.tvshow.datasource

import com.example.tmdbclient.data.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>

}