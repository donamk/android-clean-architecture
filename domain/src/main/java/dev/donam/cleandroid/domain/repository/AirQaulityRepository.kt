package dev.donam.cleandroid.domain.repository

import dev.donam.cleandroid.domain.entity.AirQualityEntity
import dev.forkhandles.result4k.Result

interface AirQualityRepository {
    suspend fun getAirQuality(lat: String, lon: String, key: String): Result<AirQualityEntity, Exception>
}