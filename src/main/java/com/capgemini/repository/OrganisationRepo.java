package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Organisation;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation, Integer> {

}
