package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Organisation;
import com.capgemini.exception.FeedbackException;
import com.capgemini.repository.OrganisationRepo;

@Service
public class OrganisationServiceImpl implements OrganisationService {

	@Autowired
	private OrganisationRepo organisationRepo;

	@Autowired
	private RatingCriteriaService ratingCriteriaService;

	@Override
	public Organisation details(Organisation org) {
		// TODO Auto-generated method stub
		return organisationRepo.save(org);
	}

	@Override
	public List<Organisation> fetchAll() {
		// TODO Auto-generated method stub
		return organisationRepo.findAll();
	}

	@Override
	public Organisation update(Organisation org) throws FeedbackException {
		Optional<Organisation> o = organisationRepo.findById(org.getOrgID());
		if (o.isPresent()) {
			Organisation updatedOrg = o.get();
			updatedOrg.setCreditCard(org.isCreditCard());
			updatedOrg.setOrgEmployees(org.getOrgEmployees());
			updatedOrg.setOrgRevenue(org.getOrgRevenue());
			updatedOrg.setOrgVideokyc(org.isOrgVideokyc());
			// updatedOrg.setRating(this.calculateRating(org.getOrgID()));
			organisationRepo.save(updatedOrg);

			return updatedOrg;
		} else {
			throw new FeedbackException("Record not found");

		}

	}

	@Override
	public Organisation calculateRating(int orgId) {
		long rating = 0;
		Organisation org = organisationRepo.findById(orgId).get();

		rating = ratingCriteriaService.fetchScoreByType("Revenue")
				+ ratingCriteriaService.fetchScoreByType("Employees");

		if (org.isCreditCard() || org.isOrgVideokyc()) {
			rating += 2;
		}

		rating = (rating / 3);
		org.setRating(rating);
		
		organisationRepo.save(org);
		return org;

	}

}
