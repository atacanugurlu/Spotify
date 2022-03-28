package com.atacanugurlu.spotify.data.database.album

import androidx.lifecycle.LiveData
import com.atacanugurlu.spotify.data.model.music.Album
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val albumDatabaseDao: AlbumDatabaseDao
) {

    fun insertAlbum(album: Album) {
        CoroutineScope(Dispatchers.IO).launch {
            albumDatabaseDao.addItem(album)
        }
    }

    fun getAlbumById(id: String): Album {
        return albumDatabaseDao.getItemById(id)
    }

    fun deleteAlbum(album: Album) {
        CoroutineScope(Dispatchers.IO).launch {
            albumDatabaseDao.deleteItem(album)
        }
    }

    fun clearAlbumsTable() {
        CoroutineScope(Dispatchers.IO).launch {
            albumDatabaseDao.clearTable()
        }
    }

    fun getAllAlbums(): LiveData<List<Album>> {
        return albumDatabaseDao.getAll()
    }
}
