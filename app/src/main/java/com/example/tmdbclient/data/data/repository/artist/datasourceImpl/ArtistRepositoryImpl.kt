package com.example.tmdbclient.data.data.repository.artist.datasourceImpl

import android.util.Log
import com.example.tmdbclient.data.data.model.artist.Artist
import com.example.tmdbclient.data.data.model.artist.ArtistList
import com.example.tmdbclient.data.data.model.movie.Movie
import com.example.tmdbclient.data.data.model.movie.MovieList
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists:List<Artist> = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromApi():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtists()
            val body: ArtistList? = response.body()
            if (body!=null){
                artistList = body.artists
            }

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        } else{
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        } else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}