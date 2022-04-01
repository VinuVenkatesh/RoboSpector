package com.robospector.applicationService;

import java.util.List;

import com.robospector.controller.exception.EquipmentNotFoundException;
import com.robospector.domain.PieceOfEquipment;

public interface EquipmentService {

	List<PieceOfEquipment> getAllEquipemt();

	PieceOfEquipment createPieceOfEquipment(PieceOfEquipment pieceOfEquipement);

	PieceOfEquipment updatePieceOfEquipment(int equipmentId, PieceOfEquipment pieceOfEquipment)
			throws EquipmentNotFoundException;

	PieceOfEquipment makeArchived(int equipmentId) throws EquipmentNotFoundException;

	List<PieceOfEquipment> findEquipmentWithNamePattern(String namePattern);
}
