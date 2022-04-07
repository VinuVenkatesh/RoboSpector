package com.robospector.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;


import com.robospector.applicationService.EquipmentService;
import com.robospector.controller.dto.PieceOfEquipmentDto;
import com.robospector.controller.exception.EquipmentNotFoundException;
import com.robospector.controller.exception.InvalidInputException;
import com.robospector.domain.PieceOfEquipment;


@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class EquipmentControllerTest {

	private static final int MIN_NUMBER_OF_INSPECTIONS = 5;
	private static final int MAX_NUMBER_OF_INSPECTIONS = 10;
	private static final int ID = 1;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private ModelMapper mapper;
	
	private PieceOfEquipmentDto pieceOfEquipmentDto;
	private PieceOfEquipment pieceOfEquipment;
	private List<PieceOfEquipment> equipmentRetrieved;

	
	@Mock
	private PieceOfEquipmentDtoValidator pieceOfEquipmentDtoValidator;
	
	@Mock
	private EquipmentService equipmentService;
	
	@Mock
	private RandomNumberGenerator randomNumberGenerator;
	
	@Mock
	private InspectionService inspectionService;
	
	@InjectMocks
	private EquipmentController equipmentController;
	
	@BeforeEach
	public void setUp() {
		//MockitoAnnotations.initMocks(this);
		createAPieceOfEquipmentDto();
		equipmentRetrieved = new ArrayList<>();
		pieceOfEquipment = new PieceOfEquipment();
		equipmentRetrieved.add(pieceOfEquipment);
		equipmentController = new EquipmentController(pieceOfEquipmentDtoValidator, equipmentService,randomNumberGenerator, inspectionService, mapper);
	}

	@Test
	public void givenValidEquipementToCreate_whenCreatePieceOfEquipment_thenShouldCreateEquipment() throws InvalidInputException {
		doNothing().when(pieceOfEquipmentDtoValidator).validate(pieceOfEquipmentDto);
		lenient().when(mapper.map(pieceOfEquipmentDto, PieceOfEquipment.class)).thenReturn(pieceOfEquipment);
		lenient().when(equipmentService.createPieceOfEquipment(any(PieceOfEquipment.class))).thenReturn(pieceOfEquipment);
		when(randomNumberGenerator.getRandomNumberBetween(MIN_NUMBER_OF_INSPECTIONS, MAX_NUMBER_OF_INSPECTIONS)).thenReturn(MIN_NUMBER_OF_INSPECTIONS);
		
		equipmentController.createPieceOfEquipment(pieceOfEquipmentDto);
		
		verify(pieceOfEquipmentDtoValidator,times(1)).validate(pieceOfEquipmentDto);
		verify(randomNumberGenerator,times(1)).getRandomNumberBetween(MIN_NUMBER_OF_INSPECTIONS, MAX_NUMBER_OF_INSPECTIONS);
		verify(mapper,times(1)).map(pieceOfEquipmentDto, PieceOfEquipment.class);
		verify(equipmentService,times(1)).createPieceOfEquipment(pieceOfEquipment);
		verify(inspectionService,times(MIN_NUMBER_OF_INSPECTIONS)).createInspection(anyInt());
	}
	

	@Test
	public void givenInvalidEquipementToCreate_whenCreatePieceOfEquipment_thenShouldNotCreateEquipment() throws InvalidInputException {
		doNothing().when(pieceOfEquipmentDtoValidator).validate(pieceOfEquipmentDto);
		lenient().when(mapper.map(pieceOfEquipmentDto, PieceOfEquipment.class)).thenReturn(pieceOfEquipment);
		lenient().when(equipmentService.createPieceOfEquipment(any(PieceOfEquipment.class))).thenReturn(null);
		when(randomNumberGenerator.getRandomNumberBetween(MIN_NUMBER_OF_INSPECTIONS, MAX_NUMBER_OF_INSPECTIONS)).thenReturn(MIN_NUMBER_OF_INSPECTIONS);
	
		equipmentController.createPieceOfEquipment(pieceOfEquipmentDto);
		
		verify(pieceOfEquipmentDtoValidator,times(1)).validate(pieceOfEquipmentDto);
		verify(randomNumberGenerator,times(1)).getRandomNumberBetween(MIN_NUMBER_OF_INSPECTIONS, MAX_NUMBER_OF_INSPECTIONS);
		verify(mapper,times(1)).map(pieceOfEquipmentDto, PieceOfEquipment.class);
		verify(equipmentService,times(1)).createPieceOfEquipment(pieceOfEquipment);
	}
	
	@Test
	public void givenRequestToDeleteEquipment_whenSoftDeletePieceOfEquipment_thenShouldSoftDeleteEquipment() throws EquipmentNotFoundException {
		lenient().when(equipmentService.makeArchived(ID)).thenReturn(pieceOfEquipment);
		
		equipmentController.softDeletePieceOfEquipment(ID);
		
		verify(equipmentService,times(1)).makeArchived(ID);
	}
	
	@Test
	public void givenRequestForAllEquipment_whenGetAllEquipment_thenShouldReturnAllEquipment() {
		lenient().when(equipmentService.getAllEquipemt()).thenReturn(equipmentRetrieved);
		lenient().when(mapper.map(pieceOfEquipment, PieceOfEquipmentDto.class)).thenReturn(pieceOfEquipmentDto);
		
		equipmentController.getAllEquipment();
		
		verify(mapper,times(1)).map(pieceOfEquipment, PieceOfEquipmentDto.class);
	}
	
	@Test
	public void givenRequestToCheckIfControllerIsRunning_whenHeartBeatTest_thenShouldBeAlive() {
		
		assertEquals(HttpStatus.OK, equipmentController.heartbeatTest().getStatusCode()); ;
	}
	
	
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
