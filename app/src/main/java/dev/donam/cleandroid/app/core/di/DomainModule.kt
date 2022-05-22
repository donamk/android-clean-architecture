package dev.donam.cleandroid.app.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.donam.cleandroid.data.repository.AirQualityRepositoryImpl
import dev.donam.cleandroid.domain.repository.AirQualityRepository

@Module(includes = [DomainModule.Binders::class])
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface Binders {
        @Binds
        fun bindAirQualityRepository(
            repoImpl: AirQualityRepositoryImpl
        ): AirQualityRepository
    }

}