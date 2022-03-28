package com.atacanugurlu.spotify.di

import com.atacanugurlu.spotify.network.LocalDataSource
import com.atacanugurlu.spotify.network.LocalDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {

    @Binds
    fun bindLocalDataSource(
        localDataSourceImp: LocalDataSourceImp
    ): LocalDataSource
}
