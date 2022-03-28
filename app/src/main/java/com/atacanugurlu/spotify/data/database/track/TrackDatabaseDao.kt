package com.atacanugurlu.spotify.data.database.track

import androidx.lifecycle.LiveData
import androidx.room.*
import com.atacanugurlu.spotify.data.model.music.Track

@Dao
interface TrackDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(track: Track)

    @Query("SELECT * from tracks_table WHERE id = :key")
    fun getItemById(key: String): Track

    @Delete
    suspend fun deleteItem(track: Track)

    @Query("DELETE FROM tracks_table")
    fun clearTable()

    @Query("SELECT * FROM tracks_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Track>>
}
