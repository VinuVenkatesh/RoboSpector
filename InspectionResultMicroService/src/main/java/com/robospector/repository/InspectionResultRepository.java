package com.robospector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robospector.domain.InspectionResult;

@Repository
public interface InspectionResultRepository extends JpaRepository<InspectionResult, Integer> {

}
