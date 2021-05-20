package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RatingCriteria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingID;
	
	private long min;
	private long max;
	private String type;
	private int score;
	public int getRatingID() {
		return ratingID;
	}
	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}
	public long getMin() {
		return min;
	}
	public void setMin(long min) {
		this.min = min;
	}
	public long getMax() {
		return max;
	}
	public void setMax(long max) {
		this.max = max;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public RatingCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RatingCriteria(int ratingID, long min, long max, String type, int score) {
		super();
		this.ratingID = ratingID;
		this.min = min;
		this.max = max;
		this.type = type;
		this.score = score;
	}
	


}
