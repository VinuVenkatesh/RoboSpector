package com.robospector.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robospector.domain.PieceOfEquipment;
import com.robospector.repository.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Override
	public List<PieceOfEquipment> getAllEquipemt() {
		return equipmentRepository.findAll();
	}

	@Override
	public PieceOfEquipment createPieceOfEquipment(PieceOfEquipment pieceOfEquipement) {
		return equipmentRepository.save(pieceOfEquipement);
	}
}
