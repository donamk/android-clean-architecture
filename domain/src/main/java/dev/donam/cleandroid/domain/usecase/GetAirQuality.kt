package dev.donam.cleandroid.domain.usecase

import dev.donam.cleandroid.domain.entity.AirQualityEntity
import dev.donam.cleandroid.domain.repository.AirQualityRepository
import dev.donam.cleandroid.domain.usecase.GetAirQuality.Params

import dev.forkhandles.result4k.Result
import javax.inject.Inject

class GetAirQuality @Inject constructor(
    private val airQualityRepository: AirQualityRepository
) : BaseUseCase<AirQualityEntity, Params> {

    override suspend fun run(params: Params): Result<AirQualityEntity, Exception> =
        airQualityRepository.getAirQuality(params.lat, params.lon, params.key)

    data class Params(val lat: String, val lon: String, val key: String)
}