package com.atacanugurlu.spotify.util.paging

import com.atacanugurlu.spotify.data.model.music.Album
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.data.model.music.Track
import com.atacanugurlu.spotify.data.model.response.ResponseModel
import com.atacanugurlu.spotify.network.Api
import retrofit2.Response
import javax.inject.Inject

class PagingDataSourceImpl @Inject constructor(
    private val service: Api
): PagingDataSource {

    override suspend fun fetchArtist(
        query: String,
        page: Int,
        pageLimit: Int
    ): Response<ResponseModel<Artist>> {
        return service.getArtist(
            artistName = query,
            page = page,
            limit = pageLimit)
    }

    override suspend fun fetchAlbum(
        query: String,
        page: Int,
        pageLimit: Int
    ): Response<ResponseModel<Album>> {
        return service.getAlbumsOfArtist(
            artistId = query,
            page = page,
            limit = pageLimit)
    }

    override suspend fun fetchTrack(
        query: String,
        page: Int,
        pageLimit: Int
    ): Response<ResponseModel<Track>> {
        return service.getTracksOfAlbum(
            albumId = query,
            page = page,
            limit = pageLimit)
    }

}