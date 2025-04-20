package com.example.tmdbclient.data.data.repository.tvshow.datasourceImpl

import com.example.tmdbclient.data.data.api.TMDBService
import com.example.tmdbclient.data.data.model.tvshow.TvShowList
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String): TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> {
        return tmdbService.getPopularTvShow(apiKey)
    }
}