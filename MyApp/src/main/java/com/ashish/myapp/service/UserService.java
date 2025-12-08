package com.ashish.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashish.myapp.entity.User;
import com.ashish.myapp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public List<User> getUser(){
		return userRepository.findAll();

	}
	public User saveUser(User user) {

	    // Print the user data before saving
	    System.out.println("Before saving: " + user);

	    // Encode the password before saving
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);

	    User savedUser = userRepository.save(user);

	    // Print the saved user data (optional)
	    System.out.println("After saving: " + savedUser);

	    return savedUser;
	}



}
