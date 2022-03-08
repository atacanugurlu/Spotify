package com.atacanugurlu.spotify.data.database.track

import androidx.lifecycle.LiveData
import com.atacanugurlu.spotify.data.model.music.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrackRepository @Inject constructor(
    private val trackDatabaseDao: TrackDatabaseDao) {

    fun insertTrack(track : Track) {
        CoroutineScope(Dispatchers.IO).launch {
            trackDatabaseDao.addItem(track)
        }
    }

    fun getTrackById(id : Long) : Track {
        return trackDatabaseDao.getItemById(id)
    }

    fun deleteTrack(track : Track) {
        CoroutineScope(Dispatchers.IO).launch {
            trackDatabaseDao.deleteItem(track)
        }
    }

    fun clearTracksTable() {
        CoroutineScope(Dispatchers.IO).launch {
            trackDatabaseDao.clearTable()
        }
    }

    fun getAllTracks(): LiveData<List<Track>> {
        return trackDatabaseDao.getAll()
    }
}