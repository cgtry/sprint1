package com.capgemini.service;

import com.capgemini.entities.RatingCriteria;

public interface RatingCriteriaService {
	

	public RatingCriteria createCriteria(RatingCriteria rc);
	public int fetchScoreByType(String type);

}
