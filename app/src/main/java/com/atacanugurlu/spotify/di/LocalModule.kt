package com.atacanugurlu.spotify.di

import com.atacanugurlu.spotify.util.converter.LocalDataSource
import com.atacanugurlu.spotify.util.converter.LocalDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {

    @Binds
    abstract fun bindLocalDataSource(
        localDataSourceImp: LocalDataSourceImp
    ): LocalDataSource

}