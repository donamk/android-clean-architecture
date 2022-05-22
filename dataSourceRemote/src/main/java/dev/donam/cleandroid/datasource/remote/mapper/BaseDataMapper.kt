package dev.donam.cleandroid.datasource.remote.mapper

import dev.donam.cleandroid.data.model.AirQualityData
import dev.donam.cleandroid.datasource.remote.model.AirQualityResponse
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.NullValuePropertyMappingStrategy

interface BaseDataMapper<R, D> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun toData(response: R): D
}

@Mapper
interface AirQualityMapper: BaseDataMapper<AirQualityResponse, AirQualityData>