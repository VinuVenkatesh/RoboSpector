package com.robospector.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robospector.controller.PieceOfEquipmentDtoValidator;
import com.robospector.controller.dto.PieceOfEquipmentDto;

@Configuration
public class EquipmentConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public PieceOfEquipmentDtoValidator getPieceOfEquipmentDtoValidator() {
		return new PieceOfEquipmentDtoValidator();
	}
}
