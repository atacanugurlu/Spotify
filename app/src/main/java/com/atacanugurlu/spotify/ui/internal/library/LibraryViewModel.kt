package com.atacanugurlu.spotify.ui.internal.library


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.atacanugurlu.spotify.data.database.artist.ArtistRepository
import com.atacanugurlu.spotify.data.database.track.TrackRepository
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val trackRepository: TrackRepository
) : ViewModel() {

    /*
    fun getFavouriteTracks(): LiveData<List<Artist>> {
        return trackRepository.getTracks()
    }

     */

    var tracksPage = 1





}