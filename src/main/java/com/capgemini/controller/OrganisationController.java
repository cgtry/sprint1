package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Organisation;
//import com.capgemini.exception.FeedbackException;
//import com.capgemini.repository.OrganisationRepo;
import com.capgemini.service.OrganisationService;
//import com.capgemini.service.RatingCriteriaService;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationController {

	@Autowired
	private OrganisationService organisationService;

	@PostMapping("/details")
	public String organisationDetails(@RequestBody Organisation organisation) {
		organisationService.details(organisation);
		return "Organisation Details added";

	}

	@GetMapping("/")
	public List<Organisation> allOrganisation() {
		return organisationService.fetchAll();
	}

	@PutMapping("/update/{orgId}")
	public ResponseEntity<Organisation> updateDetails(@PathVariable int orgId, @RequestBody Organisation org)
			throws Exception {

		org.setOrgID(orgId);

		return ResponseEntity.ok().body(organisationService.update(org));

	}
	
	@PutMapping("/setrating/{orgId}")
	public String setRating(@PathVariable int orgId) {
		organisationService.calculateRating(orgId);
		return "rating calculated";
	}

}
