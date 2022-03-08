package com.atacanugurlu.spotify.data.database.album

import androidx.lifecycle.LiveData
import androidx.room.*
import com.atacanugurlu.spotify.data.model.music.Album
import com.atacanugurlu.spotify.data.model.music.Track

@Dao
interface AlbumDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(album: Album)

    @Query("SELECT * from albums_table WHERE database_id = :key")
    fun getItemById(key: Long): Album

    @Delete
    suspend fun deleteItem(album: Album)

    @Query("DELETE FROM albums_table")
    fun clearTable()

    @Query("SELECT * FROM albums_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Album>>
}