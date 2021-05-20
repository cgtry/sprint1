package com.capgemini.service;

import com.capgemini.entities.User;

public interface LoginRegister {

	public User registration(User user);

	public User fetchUserByEmailID(String email);

	public User fetchUserByEmailIDAndPassword(String email, String password);
}
