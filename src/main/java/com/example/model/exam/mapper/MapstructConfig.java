package com.example.model.exam.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
		componentModel = MappingConstants.ComponentModel.DEFAULT,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MapstructConfig {
}
