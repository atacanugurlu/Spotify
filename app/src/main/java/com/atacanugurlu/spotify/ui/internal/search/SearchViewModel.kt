package com.atacanugurlu.spotify.ui.internal.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val artistRepository: Repository,
) : ViewModel(){


    fun getSearchedArtists(artistName : String){
        viewModelScope.launch(Dispatchers.IO) {
            artistRepository.getArtists(
                1,
                artistName,
                ::onListedArtistsFetched,
                ::onError
            )
        }
    }
    private fun onListedArtistsFetched(artists: List<Artist>) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("movies", "$artists")
        }
    }

    private fun onError() {
        Log.d("List", "Failed")
    }
}