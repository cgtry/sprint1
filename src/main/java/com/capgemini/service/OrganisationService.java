package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Organisation;

public interface OrganisationService {
	public Organisation details(Organisation org);
	public List<Organisation> fetchAll();
	public Organisation update(Organisation org) throws Exception;
	public Organisation calculateRating(int orgId);
}
