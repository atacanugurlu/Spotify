package com.atacanugurlu.spotify.data.database.artist

import androidx.lifecycle.LiveData
import com.atacanugurlu.spotify.data.model.music.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtistRepository @Inject constructor(
    private val artistDatabaseDao: ArtistDatabaseDao) {

    fun insertArtist(artist : Artist) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDatabaseDao.addItem(artist)
        }
    }

    fun getArtistById(id : Long) : Artist {
        return artistDatabaseDao.getItemById(id)
    }

    fun deleteArtist(artist : Artist) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDatabaseDao.deleteItem(artist)
        }
    }

    fun clearArtistsTable() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDatabaseDao.clearTable()
        }
    }

    fun getAllArtists(): LiveData<List<Artist>> {
        return artistDatabaseDao.getAll()
    }
}