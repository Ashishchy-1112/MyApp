package com.ashish.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.myapp.entity.User;
import com.ashish.myapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	UserService userService;
	@GetMapping("/list ")
	public List<User> getAll(){
		return userService.getUser();
	}

	@PostMapping("/signup")
	public User signUp(User user) {
		return userService.saveUser(user);
	}
	
}
