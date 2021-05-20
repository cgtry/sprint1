package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.service.OrganisationService;

@Entity
public class Organisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orgID;

	private String orgName;
	private String orgHeadquarters;
	private long orgRevenue;
	private long orgEmployees;
	private boolean orgVideokyc;
	private boolean creditCard;
	private long rating;
	
	//@OneToMany(mappedBy = "org")
	//private List<Feedback> orgFeedbacks=new ArrayList<>();
	

	public long getRating() {
		return rating;
	}

	public Organisation(int orgID, String orgName, String orgHeadquarters, long orgRevenue, long orgEmployees,
			boolean orgVideokyc, boolean creditCard, long rating) {
		super();
		this.orgID = orgID;
		this.orgName = orgName;
		this.orgHeadquarters = orgHeadquarters;
		this.orgRevenue = orgRevenue;
		this.orgEmployees = orgEmployees;
		this.orgVideokyc = orgVideokyc;
		this.creditCard = creditCard;
		this.rating = rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public boolean isOrgVideokyc() {
		return orgVideokyc;
	}

	public void setOrgVideokyc(boolean orgVideokyc) {
		this.orgVideokyc = orgVideokyc;
	}

	public boolean isCreditCard() {
		return creditCard;
	}

	public void setCreditCard(boolean creditCard) {
		this.creditCard = creditCard;
	}

	public long getOrgRevenue() {
		return orgRevenue;
	}

	public void setOrgRevenue(long orgRevenue) {
		this.orgRevenue = orgRevenue;
	}

	public long getOrgEmployees() {
		return orgEmployees;
	}

	public void setOrgEmployees(long orgEmployees) {
		this.orgEmployees = orgEmployees;
	}

	// private String orgRevenue;
	public int getOrgID() {
		return orgID;
	}

	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgHeadquarters() {
		return orgHeadquarters;
	}

	public void setOrgHeadquarters(String orgHeadquarters) {
		this.orgHeadquarters = orgHeadquarters;
	}

	//public List<Feedback> getOrgFeedbacks() {
		//return orgFeedbacks;
	//}

	//public void setOrgFeedbacks(List<Feedback> orgFeedbacks) {
		//this.orgFeedbacks = orgFeedbacks;
	//}

	public Organisation() {
	}

}
