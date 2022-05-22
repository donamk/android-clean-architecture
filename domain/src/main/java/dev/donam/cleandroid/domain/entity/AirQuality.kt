package dev.donam.cleandroid.domain.entity

data class AirQualityEntity(
    val address: Address,
    val pollution: Pollution,
    val weather: Weather,
) {
    data class Address(
        val city: String,
        val country: String,
        val state: String
    )

    data class Pollution(
        val aqicn: Int,
        val aqius: Int,
        val maincn: String,
        val mainus: String,
        val ts: String
    )

    data class Weather(
        val hu: Int,
        val ic: String,
        val pr: Int,
        val tp: Int,
        val ts: String,
        val wd: Int,
        val ws: Double
    )
}