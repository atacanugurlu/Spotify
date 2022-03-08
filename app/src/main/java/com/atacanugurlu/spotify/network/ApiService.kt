package com.atacanugurlu.spotify.network

import com.atacanugurlu.spotify.data.model.music.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val api : Api) {

    suspend fun getArtists(
        page: Int = 1,
        artistName: String,
        onSuccess: (movies: List<Artist>) -> Unit,
        onError: () -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getArtist(page = page, artistName = artistName)

            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    onSuccess.invoke(responseBody.items)
                } else {
                    onError.invoke()
                }
            } else {
                onError.invoke()
            }
        }
    }
}
