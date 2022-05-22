package dev.donam.cleandroid.data.mapper

import dev.donam.cleandroid.data.model.AirQualityData
import dev.donam.cleandroid.domain.entity.AirQualityEntity
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.NullValuePropertyMappingStrategy

interface BaseEntityMapper<D, E> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun toEntity(data: D): E
}

@Mapper
interface AirQualityMapper: BaseEntityMapper<AirQualityData, AirQualityEntity> {

    @Mappings(
        Mapping(source = "data", target = "address"),
        Mapping(source = "data.current.pollution", target = "pollution"),
        Mapping(source = "data.current.weather", target = "weather")
    )
    override fun toEntity(data: AirQualityData): AirQualityEntity
}