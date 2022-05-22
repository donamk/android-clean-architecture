package dev.donam.cleandroid.data.repository

import dev.donam.cleandroid.data.mapper.AirQualityMapper
import dev.donam.cleandroid.data.source.IqAirRemoteDataSource
import dev.donam.cleandroid.domain.entity.AirQualityEntity
import dev.donam.cleandroid.domain.repository.AirQualityRepository
import dev.forkhandles.result4k.Result
import dev.forkhandles.result4k.map
import org.mapstruct.factory.Mappers
import javax.inject.Inject

class AirQualityRepositoryImpl @Inject constructor(
    private val iqAirRemoteDataSource: IqAirRemoteDataSource
) : AirQualityRepository {
    private val airQualityMapper: AirQualityMapper by lazy {
        Mappers.getMapper(AirQualityMapper::class.java)
    }

    override suspend fun getAirQuality(lat: String, lon: String, key: String): Result<AirQualityEntity, Exception> =
        iqAirRemoteDataSource.getAirQuality(lat, lon, key).map {
            airQualityMapper.toEntity(it)
        }
}
