package com.example.tmdbclient.data.data.repository.tvshow.datasource

import com.example.tmdbclient.data.data.model.tvshow.TvShow
import com.example.tmdbclient.data.data.model.tvshow.TvShowList

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB():List<TvShow>
    suspend fun saveTvShowToDB(tvShow:List<TvShow>)
    suspend fun clearAll()
}