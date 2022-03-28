package com.atacanugurlu.spotify.ui.internal.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.atacanugurlu.spotify.data.database.track.TrackRepository
import com.atacanugurlu.spotify.data.model.music.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val trackRepository: TrackRepository
) : ViewModel() {

    fun getFavouriteTracks(): LiveData<List<Track>> {
        return trackRepository.getAllTracks()
    }
}
