package com.robospector.controller;

import org.springframework.stereotype.Component;

import com.robospector.controller.dto.PieceOfEquipmentDto;
import com.robospector.controller.exception.InvalidInputException;

@Component
public class PieceOfEquipmentDtoValidator {

	public void validate(PieceOfEquipmentDto pieceOfEquipmentDto) throws InvalidInputException {
		if(pieceOfEquipmentDto.getName() == null || pieceOfEquipmentDto.getLocation() == null) {
			throw new InvalidInputException("Input can not be null");
		}
	}
}
