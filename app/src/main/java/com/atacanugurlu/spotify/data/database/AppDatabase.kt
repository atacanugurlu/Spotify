package com.atacanugurlu.spotify.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atacanugurlu.spotify.data.database.album.AlbumDatabaseDao
import com.atacanugurlu.spotify.data.database.artist.ArtistDatabaseDao
import com.atacanugurlu.spotify.data.database.track.TrackDatabaseDao
import com.atacanugurlu.spotify.data.model.music.Album
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.data.model.music.Track

@Database(entities = [Track::class, Artist::class, Album::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun trackDatabaseDao(): TrackDatabaseDao
    abstract fun albumDatabaseDao(): AlbumDatabaseDao
    abstract fun artistDatabaseDao(): ArtistDatabaseDao
}
