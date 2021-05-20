package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Feedback;
import com.capgemini.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepo repo;
	@Override
	public List<Feedback> getFeedbacks(int orgID) {
		List<Feedback> feedbacks=repo.findAllfeedbackByorgID(orgID);
		
		return feedbacks;
	}
	@Override
	public Feedback createFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return repo.save(feedback);
	}

}
