package com.atacanugurlu.spotify.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val application: Application) {
/*
    @Provides
    @Singleton
    fun provideDatabase() : AppDatabase {
        return Room.databaseBuilder(
            application, AppDatabase::class.java, "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideMediaDao(database: AppDatabase) : SocialDatabaseDao {
        return database.socialDatabaseDao()
    }

    @Provides
    @Singleton
    fun provideBusinessDao(database: AppDatabase) : BusinessDatabaseDao {
        return database.businessDatabaseDao()
    }

 */
}