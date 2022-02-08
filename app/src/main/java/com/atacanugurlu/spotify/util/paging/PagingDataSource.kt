package com.atacanugurlu.spotify.util.paging

import com.atacanugurlu.spotify.data.model.music.Album
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.data.model.music.Track
import com.atacanugurlu.spotify.data.model.response.ResponseModel
import retrofit2.Response

interface PagingDataSource {
    suspend fun fetchArtist(query: String, page : Int, pageLimit: Int) : Response<ResponseModel<Artist>>
    suspend fun fetchAlbum(query: String, page : Int, pageLimit: Int) : Response<ResponseModel<Album>>
    suspend fun fetchTrack(query: String, page : Int, pageLimit: Int) : Response<ResponseModel<Track>>
}