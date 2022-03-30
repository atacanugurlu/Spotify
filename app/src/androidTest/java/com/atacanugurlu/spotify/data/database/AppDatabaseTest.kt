package com.atacanugurlu.spotify.data.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.atacanugurlu.spotify.data.database.album.AlbumDatabaseDao
import com.atacanugurlu.spotify.data.database.artist.ArtistDatabaseDao
import com.atacanugurlu.spotify.data.database.track.TrackDatabaseDao
import com.atacanugurlu.spotify.domain.model.music.Album
import com.atacanugurlu.spotify.domain.model.music.Artist
import com.atacanugurlu.spotify.domain.model.music.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.io.IOException
import java.lang.Exception

class AppDatabaseTest {

    private lateinit var trackDatabaseDao: TrackDatabaseDao
    private lateinit var albumDatabaseDao: AlbumDatabaseDao
    private lateinit var artistDatabaseDao: ArtistDatabaseDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        trackDatabaseDao = db.trackDatabaseDao()
        albumDatabaseDao = db.albumDatabaseDao()
        artistDatabaseDao = db.artistDatabaseDao()
    }

    @After
    @Throws(IOException::class)
    fun destroyDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun trackDatabaseDao() {
        val mockTrack = Mockito.mock(Track::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            trackDatabaseDao.addItem(mockTrack)
        }

        Assert.assertEquals(mockTrack.title, trackDatabaseDao.getItemById(mockTrack.id).title)
    }

    @Test
    fun albumDatabaseDao() {
        val mockAlbum = Mockito.mock(Album::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            albumDatabaseDao.addItem(mockAlbum)
        }

        Assert.assertEquals(mockAlbum.title, albumDatabaseDao.getItemById(mockAlbum.id).title)
    }

    @Test
    fun artistDatabaseDao() {
        val mockArtist = Mockito.mock(Artist::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            artistDatabaseDao.addItem(mockArtist)
        }

        Assert.assertEquals(mockArtist.name, artistDatabaseDao.getItemById(mockArtist.id).name)
    }
}
