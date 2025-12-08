package com.ashish.myapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ashish.myapp.entity.User;
import com.ashish.myapp.repository.UserRepository;
import com.ashish.myapp.security.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {

        String email = req.get("email");
        String password = req.get("password");

        // 1️⃣ Check if user exists
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // 2️⃣ Validate password using BCrypt
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        // 3️⃣ Generate JWT Token
        String token = jwtUtil.generateToken(user.getEmail());
        System.out.println(token);

        // 4️⃣ Return token + email + id
        return ResponseEntity.ok(Map.of(
                "token", token,
                "email", user.getEmail(),
                "id", user.getId()
        ));
    }


}
