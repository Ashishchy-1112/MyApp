package com.ashish.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.myapp.entity.User;
import com.ashish.myapp.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/list")
	public List<User> getAll(){
		return userService.getUser();
	}


	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
	    // prints whole object
	    User saved = userService.saveUser(user);

	    return ResponseEntity.ok(saved);
	}

}
