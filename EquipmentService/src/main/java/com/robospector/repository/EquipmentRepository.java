package com.robospector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robospector.domain.PieceOfEquipment;

@Repository
public interface EquipmentRepository extends MongoRepository <PieceOfEquipment, Integer>{
	
}
