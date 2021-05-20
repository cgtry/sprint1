package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.RatingCriteria;
import com.capgemini.service.RatingCriteriaService;

@RestController
@RequestMapping("/api/Ratingcriteria")
public class RatingCriteraController {

	@Autowired
	private RatingCriteriaService ratingCriteriaService;

	@PostMapping("/")
	public String rating(@RequestBody RatingCriteria ratingCriteria) {

		ratingCriteriaService.createCriteria(ratingCriteria);
		return "Rating Criteria successfully established";
	}

}
