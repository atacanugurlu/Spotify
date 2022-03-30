package com.atacanugurlu.spotify.core.di

import com.atacanugurlu.spotify.data.network.LocalDataSource
import com.atacanugurlu.spotify.data.network.LocalDataSourceImp
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
