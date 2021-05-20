package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackID;
	private int orgId;



	public Feedback(int feedbackID, int orgId, String message, Organisation org) {
		super();
		this.feedbackID = feedbackID;
		this.orgId = orgId;
		this.message = message;
		this.org = org;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	private String message;

	@ManyToOne
	@JoinColumn(name = "orgfeedback_fk", referencedColumnName = "orgID")
	private Organisation org;

	public int getFeedbackID() {
		return feedbackID;
	}

	public Organisation getOrg() {
		return org;
	}

	public void setOrg(Organisation org) {
		this.org = org;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Feedback() {
	}

}
