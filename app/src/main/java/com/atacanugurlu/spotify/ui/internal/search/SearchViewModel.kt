package com.atacanugurlu.spotify.ui.internal.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atacanugurlu.spotify.data.database.artist.ArtistRepository
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val artistRepository: ArtistRepository
) : ViewModel() {

    fun getArtists(): LiveData<List<Artist>> {
        return artistRepository.getAllArtists()
    }

    private var artistsPage = 1

    fun getSearchedArtists(artistName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getArtists(
                artistsPage,
                artistName,
                ::onListedArtistsFetched,
                ::onError
            )
        }
    }

    private fun onListedArtistsFetched(artists: List<Artist>?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (artists != null) {
                for (artist in artists) {
                    artistRepository.insertArtist(artist)
                }
            }
        }
    }

    private fun onError() {
        Log.d("List", "Failed")
    }
}
