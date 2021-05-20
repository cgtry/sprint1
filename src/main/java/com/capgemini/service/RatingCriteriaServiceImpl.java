package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.RatingCriteria;
import com.capgemini.repository.RatingCriteriaRepo;
@Service
public class RatingCriteriaServiceImpl implements RatingCriteriaService {
	
	
	@Autowired
	private RatingCriteriaRepo ratingCriteriaRepo;

	@Override
	public RatingCriteria createCriteria(RatingCriteria rc) {
		// TODO Auto-generated method stub
		return ratingCriteriaRepo.save(rc);
	}

	@Override
	public int fetchScoreByType(String type) {
		// TODO Auto-generated method stub
		 RatingCriteria obj=ratingCriteriaRepo.findByType(type);
		
		return obj.getScore();
		
		
	}
	

}
