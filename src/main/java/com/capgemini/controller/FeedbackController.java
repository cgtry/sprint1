package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Feedback;
import com.capgemini.entities.Organisation;
import com.capgemini.exception.FeedbackException;
import com.capgemini.repository.FeedbackRepo;
import com.capgemini.repository.OrganisationRepo;
import com.capgemini.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private FeedbackRepo feedbackRepo;
	
	@Autowired
	private OrganisationRepo organisationRepo;

	@GetMapping("/{orgID}")
	public ResponseEntity<List<Feedback>> getFeedbacks(@PathVariable("orgID") int orgID) throws FeedbackException {
		ResponseEntity<List<Feedback>> response = null;
		List<Feedback> feedbackList = feedbackService.getFeedbacks(orgID);
		if (feedbackList == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(feedbackList, HttpStatus.OK);
		}
		return response;
	}

	@PostMapping("/savefeedback")
	public String create(@RequestBody Feedback f) {

		feedbackService.createFeedback(f);

		return "Message generated";
	}
	
@PutMapping("/{orgId}/organisation/{orgID}")
	public String assign(@PathVariable int orgId,@PathVariable int orgID) {
		Organisation o=organisationRepo.findById(orgId).get();
		Feedback f=feedbackRepo.findById(orgID).get();
		
	
		f.setOrg(o);
		
	
	organisationRepo.save(o);
	
	return "Linked";
		
		
		
		
	}

}
