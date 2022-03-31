package com.robospector.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.robospector.applicationService.EquipmentService;
import com.robospector.domain.PieceOfEquipment;

@SpringBootTest
@AutoConfigureMockMvc
class EquipmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private ModelMapper mapper;
	
	private PieceOfEquipmentDto pieceOfEquipmentDto;
	
	@Mock
	private EquipmentService equipmentService;
	
	@InjectMocks
	private EquipmentController equipmentController;
	
	@BeforeEach
	public void setUp() {
		createAPieceOfEquipmentDto();
		//equipmentController = new EquipmentController(equipmentService);
		//mockMvc = MockMvcBuilders.standaloneSetup(equipmentController).build();
	}
	
	// TODO: Test if user has been given creation permission
	/*
	@Test
	public void givenEquipementDto_whenCreatePieceOfEquipment_thenShouldConvertToPieceOfEquipementClass() {
		equipmentController.createPieceOfEquipment(pieceOfEquipmentDto);
		
		verify(mapper, times(1)).map(pieceOfEquipmentDto, PieceOfEquipement.class);
	}
	*/
	
	/*
	@Test
	public void givenEquipementDto_whenCreatePieceOfEquipment_thenEquipmentShouldBeCreated() {
		equipmentController.createPieceOfEquipment(pieceOfEquipmentDto);
		
		verify(equipmentService, times(1)).createPieceOfEquipment(pieceOfEquipmentDto);
	}
	*/

	/*
	@Test
	public void givenAUserWithCreationPerssion_whenCreateEquipment_thenEquipmentShouldBeCreated() {
		equipmentController.createPieceOfEquipment(pieceOfEquipmentDto);
		
		//verify(equipmentService, times(1)).createEquipment();
	}
	*/
	
	@Test
	public void givenAUser_whenGetAllEquipment_thenShouldGetEquipment() {
		equipmentController.getAllEquipment();
		
		verify(equipmentService, times(1)).getAllEquipemt();
	}
	
	private void createAPieceOfEquipmentDto() {
		pieceOfEquipmentDto = new PieceOfEquipmentDto();
	}
}
