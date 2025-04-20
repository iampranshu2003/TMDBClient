package com.example.tmdbclient.data.data.repository.tvshow.datasource

import com.example.tmdbclient.data.data.model.movie.Movie
import com.example.tmdbclient.data.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShow:List<TvShow>)
}