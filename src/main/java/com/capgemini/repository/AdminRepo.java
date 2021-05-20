package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
