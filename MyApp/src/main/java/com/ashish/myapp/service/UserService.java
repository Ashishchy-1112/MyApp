package com.ashish.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashish.myapp.entity.User;
import com.ashish.myapp.repository.UserRepository;
import com.ashish.myapp.security.AppConfig;

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

		// Encode the password before saving
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		return userRepository.save(user);
	}


}
