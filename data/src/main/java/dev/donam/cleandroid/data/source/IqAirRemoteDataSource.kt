package dev.donam.cleandroid.data.source

import dev.donam.cleandroid.data.model.AirQualityData
import dev.forkhandles.result4k.Result

interface IqAirRemoteDataSource {
    suspend fun getAirQuality(lat : String, lon : String, key : String) : Result<AirQualityData, Exception>
}
