package dev.donam.cleandroid.presentation.mapper

import dev.donam.cleandroid.domain.entity.AirQualityEntity
import dev.donam.cleandroid.presentation.model.AirQualityView
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.NullValuePropertyMappingStrategy

interface BaseViewMapper<E, V> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun toView(entity: E): V
}

@Mapper
interface AirQualityMapper: BaseViewMapper<AirQualityEntity, AirQualityView>