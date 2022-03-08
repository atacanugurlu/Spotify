package com.atacanugurlu.spotify.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.atacanugurlu.spotify.data.database.AppDatabase
import com.atacanugurlu.spotify.data.database.album.AlbumDatabaseDao
import com.atacanugurlu.spotify.data.database.artist.ArtistDatabaseDao
import com.atacanugurlu.spotify.data.database.track.TrackDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule() {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) : AppDatabase {
        return Room.databaseBuilder(
            appContext, AppDatabase::class.java, "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideTrackDao(database: AppDatabase) : TrackDatabaseDao {
        return database.trackDatabaseDao()
    }

    @Provides
    @Singleton
    fun provideAlbumDao(database: AppDatabase) : AlbumDatabaseDao {
        return database.albumDatabaseDao()
    }

    @Provides
    @Singleton
    fun provideArtistDao(database: AppDatabase) : ArtistDatabaseDao {
        return database.artistDatabaseDao()
    }

}