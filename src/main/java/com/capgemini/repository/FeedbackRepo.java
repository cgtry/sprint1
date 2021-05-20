package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{
	
	@Query("SELECT f FROM Feedback f WHERE f.orgId=:orgId")
	List<Feedback> findAllfeedbackByorgID(int orgId);
}
