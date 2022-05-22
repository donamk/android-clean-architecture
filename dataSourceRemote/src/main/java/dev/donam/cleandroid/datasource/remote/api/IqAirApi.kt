package dev.donam.cleandroid.datasource.remote.api

import dev.donam.cleandroid.datasource.remote.model.AirQualityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IqAirApi {
    @GET("nearest_city")
    suspend fun getAirQuality(@Query("lat") lat : String, @Query("lon") lon : String, @Query("key") key : String ) : Response<AirQualityResponse>
}

// curl --location -g --request GET 'http://api.airvisual.com/v2/nearest_city?lat=37.50&lon=127.02&key=059dd92d-23ef-4c5d-a442-e32079c782a6'