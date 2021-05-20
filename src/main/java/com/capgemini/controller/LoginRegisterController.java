package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.User;
import com.capgemini.service.LoginRegister;

@RestController
@RequestMapping("/api")
public class LoginRegisterController {

	@Autowired
	private LoginRegister service;
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user){
		String tempEmailId = user.getUserEmail();
		String tempPassword = user.getPassword();
		User uObj = null;
		if (tempEmailId != null && tempPassword != null) {
			uObj = service.fetchUserByEmailIDAndPassword(tempEmailId, tempPassword);
		}
		return uObj;
	}

	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getUserEmail();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User obj = service.fetchUserByEmailID(tempEmailId);
			if (obj != null) {
				throw new Exception("User with email " + tempEmailId + " is already registered");
			}
		}
		User uObj = null;
		uObj = service.registration(user);
		return uObj;
	}
}
