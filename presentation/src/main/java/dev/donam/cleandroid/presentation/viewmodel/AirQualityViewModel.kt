package dev.donam.cleandroid.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.donam.cleandroid.domain.entity.AirQualityEntity
import dev.donam.cleandroid.domain.usecase.GetAirQuality
import dev.donam.cleandroid.domain.usecase.GetAirQuality.*
import dev.donam.cleandroid.presentation.mapper.AirQualityMapper
import dev.donam.cleandroid.presentation.model.AirQualityView
import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Success
import org.mapstruct.factory.Mappers
import javax.inject.Inject

@HiltViewModel
class AirQualityViewModel @Inject constructor(
    private val getAirQuality: GetAirQuality
) : BaseViewModel() {
    private val airQualityMapper: AirQualityMapper by lazy {
        Mappers.getMapper(AirQualityMapper::class.java)
    }

    private val _airQuality: MutableLiveData<AirQualityView> = MutableLiveData()
    val airQuality: LiveData<AirQualityView> = _airQuality

    fun loadAirQualities(lat: String, lon: String, key: String) =
        getAirQuality(Params(lat, lon, key), viewModelScope) {
            when (it) {
                is Failure -> handleException(it.reason)
                is Success -> handleAirQualities(it.value)
            }
        }

    private fun handleAirQualities(airQualityEntity: AirQualityEntity) {
        _airQuality.value = airQualityMapper.toView(airQualityEntity)
    }
}
