package com.robospector.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.robospector.applicationService.EquipmentServiceImpl;
import com.robospector.domain.PieceOfEquipment;
import com.robospector.repository.EquipmentRepository;

@ExtendWith(MockitoExtension.class)
class EquipmentServiceImplTest {

	private PieceOfEquipment aPieceOfEquipment;
	
	@Mock
	private EquipmentRepository equipmentRepository;
	
	@InjectMocks
	private EquipmentServiceImpl equipmentService;
	
	@BeforeEach
	public void setUp() {
		aPieceOfEquipment = new PieceOfEquipment();
	}
	
	@Test
	void givenAPieceOfEquipment_whenCreatePieceOfEquipment_thenEquipmentShouldNotBeArchived() { // Todo: rename method to save()
		equipmentService.createPieceOfEquipment(aPieceOfEquipment);
		
		assertFalse(aPieceOfEquipment.isArchived());
	}
		
	@Test
	void givenAPieceOfEquipemnt_whenCreatePieceOfEquipment_thenRepositorySouldSaveThePieceOfEquipement() {
		equipmentService.createPieceOfEquipment(aPieceOfEquipment);
		
		verify(equipmentRepository).save(aPieceOfEquipment);
	}
}
