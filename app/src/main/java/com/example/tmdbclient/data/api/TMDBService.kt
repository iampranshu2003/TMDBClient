package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.ArtistList
import com.example.tmdbclient.data.MovieList
import com.example.tmdbclient.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String): Response<MovieList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key")apiKey: String): Response<ArtistList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key")apiKey: String): Response<TvShowList>
}