package com.atacanugurlu.spotify.network

import com.atacanugurlu.spotify.data.model.music.Album
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.data.model.music.Track
import com.atacanugurlu.spotify.data.model.response.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("artist/{id}/albums")
    @Headers(
        "No-Locality: true"
    )

    suspend fun queryForAlbums(
        @Path("id") artistId: String? = "",
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("index") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Album>>

    @GET("search/artist")
    @Headers(
        "No-Locality: true"
    )
    suspend fun queryForArtists(
        @Query("q") artistName: String,
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("index") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Artist>>

    @GET("album/{id}/tracks")
    @Headers(
        "No-Locality: true"
    )
    suspend fun queryForTracks(
        @Path("id") albumId: String? = "",
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("index") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Track>>
}