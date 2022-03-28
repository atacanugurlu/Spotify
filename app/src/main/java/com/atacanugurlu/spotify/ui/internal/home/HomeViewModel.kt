package com.atacanugurlu.spotify.ui.internal.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atacanugurlu.spotify.data.database.track.TrackRepository
import com.atacanugurlu.spotify.data.model.music.Track
import com.atacanugurlu.spotify.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val trackRepository: TrackRepository
) : ViewModel() {

    fun getTracks(): LiveData<List<Track>> {
        return trackRepository.getAllTracks()
    }

    private var tracksPage = 1

    fun getSearchedTracks(trackName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTracks(
                tracksPage,
                trackName,
                ::onListedArtistsFetched,
                ::onError
            )
        }
    }

    private fun onListedArtistsFetched(tracks: List<Track>?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (tracks != null) {
                for (track in tracks) {
                    trackRepository.insertTrack(track)
                }
            }
        }
    }

    private fun onError() {
        Log.d("List", "Failed")
    }
}
