package com.robospector.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robospector.domain.PieceOfEquipment;

@Repository
public interface EquipmentRepository extends MongoRepository <PieceOfEquipment, Integer> {

	List<PieceOfEquipment> findByIsArchived(Boolean isArchived);
	
	List<PieceOfEquipment> findByNameLikeAndIsArchivedFalse(String name, Boolean isArchived);
}
