package dev.donam.cleandroid.app.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.donam.cleandroid.data.source.IqAirRemoteDataSource
import dev.donam.cleandroid.datasource.remote.service.IqAirRemoteDataSourceImpl

@Module(includes = [DataModule.Binders::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface Binders {
        @Binds
        fun bindIqAirRemoteDataSource(
            repoImpl: IqAirRemoteDataSourceImpl
        ): IqAirRemoteDataSource
    }

}