package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.RatingCriteria;

@Repository
public interface RatingCriteriaRepo extends JpaRepository<RatingCriteria, Integer> {
	
	public RatingCriteria findByType(String type);

}
