package dev.donam.cleandroid.datasource.remote.service

import dev.donam.cleandroid.data.model.AirQualityData
import dev.donam.cleandroid.data.source.IqAirRemoteDataSource
import dev.donam.cleandroid.datasource.remote.api.IqAirApi
import dev.donam.cleandroid.datasource.remote.mapper.AirQualityMapper
import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Result
import dev.forkhandles.result4k.Success
import dev.forkhandles.result4k.map
import org.mapstruct.factory.Mappers
import retrofit2.Response
import retrofit2.Retrofit
import java.io.InterruptedIOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IqAirRemoteDataSourceImpl @Inject constructor(
    retrofit: Retrofit
) : IqAirRemoteDataSource {
    private val iqAirApi: IqAirApi by lazy { retrofit.create(IqAirApi::class.java) }
    private val airQualityMapper: AirQualityMapper by lazy {
        Mappers.getMapper(AirQualityMapper::class.java)
    }

    override suspend fun getAirQuality(
        lat: String,
        lon: String,
        key: String
    ) : Result<AirQualityData, Exception> =
        iqAirApi.getAirQuality(lat, lon, key)
            .toResult()
            .map { airQualityMapper.toData(it) }

}

fun <T> Response<T>.toResult(): Result<T, Exception> = if (this.isSuccessful) {
    Success(this.body()!!)
} else {
    when (this.code()) {
        in 400..499 -> Failure(InterruptedIOException("Client Side Error ${this.code()}"))
        in 500..599 -> Failure(InterruptedIOException("Serer Side Error ${this.code()}"))
        else -> Failure(RuntimeException("Unknown ${this.code()}"))
    }
}