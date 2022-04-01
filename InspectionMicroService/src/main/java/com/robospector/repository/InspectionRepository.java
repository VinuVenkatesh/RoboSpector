package com.robospector.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robospector.domain.Inspection;

@Repository
public interface InspectionRepository extends MongoRepository<Inspection, String> {

	Optional<Inspection> findFirstByNameOrderByDateTimeDateDescDateTimeTimeDesc(String name);
	
	List<Inspection> findByNameOrderByVerificationDetailsInspectionResultSeverityDesc(String name);
}
