package com.robospector.applicationService;

import java.util.List;

import com.robospector.domain.PieceOfEquipment;

public interface EquipmentService {

	List<PieceOfEquipment> getAllEquipemt();

	PieceOfEquipment createPieceOfEquipment(PieceOfEquipment pieceOfEquipement);
}
