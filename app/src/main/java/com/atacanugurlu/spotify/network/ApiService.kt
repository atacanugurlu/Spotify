package com.atacanugurlu.spotify.network

import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.data.model.music.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val api : Api) {

    suspend fun getArtists(
        page: Int = 1,
        artistName: String,
        onSuccess: (artists: List<Artist>?) -> Unit,
        onError: () -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getArtist(page = page, artistName = artistName)

            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    onSuccess.invoke(responseBody.data)
                } else {
                    onError.invoke()
                }
            } else {
                onError.invoke()
            }
        }
    }


    suspend fun getTracks(
        page: Int = 1,
        trackName: String,
        onSuccess: (tracks: List<Track>?) -> Unit,
        onError: () -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getTrack(page = page, trackName = trackName)

            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    onSuccess.invoke(responseBody.data)
                } else {
                    onError.invoke()
                }
            } else {
                onError.invoke()
            }
        }
    }
}
