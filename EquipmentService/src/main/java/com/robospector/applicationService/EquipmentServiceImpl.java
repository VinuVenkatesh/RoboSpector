package com.robospector.applicationService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robospector.controller.exception.EquipmentNotFoundException;
import com.robospector.domain.PieceOfEquipment;
import com.robospector.repository.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	private static final boolean INITIAL_ARCHIVED_STATE = false;
	
	@Autowired
	private EquipmentRepository equipmentRepository;

	@Override
	public PieceOfEquipment createPieceOfEquipment(PieceOfEquipment pieceOfEquipement) {
		pieceOfEquipement.setArchived(INITIAL_ARCHIVED_STATE);
		return equipmentRepository.save(pieceOfEquipement);
	}

	@Override
	public List<PieceOfEquipment> findEquipmentWithNamePattern(String namePattern) {
		return equipmentRepository.findByNameLikeAndIsArchivedFalse(namePattern, INITIAL_ARCHIVED_STATE);
	}
	
	@Override
	public PieceOfEquipment updatePieceOfEquipment(int equipmentId, PieceOfEquipment pieceOfEquipment)
			throws EquipmentNotFoundException {
		Optional<PieceOfEquipment> pieceOfEquipmentRetrieved =  equipmentRepository.findById(equipmentId);
		
		if(pieceOfEquipmentRetrieved.isEmpty()) {
			throw new EquipmentNotFoundException("Equipment with id " + equipmentId + "not found");
		}
		
		pieceOfEquipment.setId(equipmentId);
		return equipmentRepository.save(pieceOfEquipment);
	}

	@Override
	public PieceOfEquipment makeArchived(int equipmentId) throws EquipmentNotFoundException {
		Optional<PieceOfEquipment> pieceOfEquipmentRetrieved =  equipmentRepository.findById(equipmentId);
		
		if(pieceOfEquipmentRetrieved.isEmpty()) {
			throw new EquipmentNotFoundException("Equipment with id " + equipmentId + "not found");
		}
		
		PieceOfEquipment pieceOfEquipment = pieceOfEquipmentRetrieved.get();
		pieceOfEquipment.setArchived(!INITIAL_ARCHIVED_STATE);
		return equipmentRepository.save(pieceOfEquipment);
	}
	
	@Override
	public List<PieceOfEquipment> getAllEquipemt() {
		return equipmentRepository.findByIsArchived(false);
	}
}
