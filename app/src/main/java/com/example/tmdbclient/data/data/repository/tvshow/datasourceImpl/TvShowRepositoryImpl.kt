package com.example.tmdbclient.data.data.repository.tvshow.datasourceImpl

import android.util.Log
import com.example.tmdbclient.data.data.model.movie.MovieList
import com.example.tmdbclient.data.data.model.tvshow.TvShow
import com.example.tmdbclient.data.data.model.tvshow.TvShowList
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
):TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows:List<TvShow> = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            val response:Response<TvShowList> = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        } else{
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList

    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        } else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}