package com.robospector.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.robospector.applicationService.EquipmentService;
import com.robospector.domain.User;

@ExtendWith(MockitoExtension.class)
class EquipmentServiceImplTest {

	private static User user1;
	
	private EquipmentService equipmentService;
	
	@BeforeEach
	public void setUp() {
		user1 = new User();
	}
	
	// ToDo Verify userToken then set creationpermission to true
	// verify if user has permission to create before creating
	
	@Test
	void whenCreatePieceOfEquipment_thenEquipmentShouldBeCreated() {
		user1.grantCreationPermission(true);
		
		//PieceOfEquipement pieceOfEquipement	= equipmentService.createPieceOfEquipment();
	}
}
