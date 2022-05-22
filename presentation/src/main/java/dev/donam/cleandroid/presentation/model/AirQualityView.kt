package dev.donam.cleandroid.presentation.model

data class AirQualityView(
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
        val aqius: Int,
        val mainus: String,
    )

    data class Weather(
        val hu: Int,
        val tp: Int,
        val ws: Double
    )
}