package com.atacanugurlu.spotify.data.api

import com.atacanugurlu.spotify.data.network.OrderType
import com.atacanugurlu.spotify.domain.model.music.Album
import com.atacanugurlu.spotify.domain.model.music.Artist
import com.atacanugurlu.spotify.domain.model.music.Track
import com.atacanugurlu.spotify.data.entities.ResponseModel
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

    suspend fun getAlbumsOfArtist(
        @Path("id") artistId: String? = "",
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Album>>

    @GET("search/artist")
    @Headers(
        "No-Locality: true"
    )
    suspend fun getArtist(
        @Query("q") artistName: String,
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Artist>>

    @GET("search/track")
    @Headers(
        "No-Locality: true"
    )
    suspend fun getTrack(
        @Query("q") trackName: String,
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Track>>

    @GET("album/{id}/tracks")
    @Headers(
        "No-Locality: true"
    )
    suspend fun getTracksOfAlbum(
        @Path("id") albumId: String? = "",
        @Query("order") order: String = OrderType.RANKING.name,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 25
    ): Response<ResponseModel<Track>>
}
