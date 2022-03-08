package com.atacanugurlu.spotify.data.database.artist

import androidx.lifecycle.LiveData
import androidx.room.*
import com.atacanugurlu.spotify.data.model.music.Artist

@Dao
interface ArtistDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(artist: Artist)

    @Query("SELECT * from artists_table WHERE database_id = :key")
    fun getItemById(key: Long): Artist

    @Delete
    suspend fun deleteItem(artist: Artist)

    @Query("DELETE FROM artists_table")
    fun clearTable()

    @Query("SELECT * FROM artists_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Artist>>
}