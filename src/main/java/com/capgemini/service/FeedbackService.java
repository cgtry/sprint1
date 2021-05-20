package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Feedback;

public interface FeedbackService {

	List<Feedback> getFeedbacks(int orgID);
	Feedback createFeedback(Feedback feedback);
}
