package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineFoodOrderingSystem.Entity.User;
import com.example.OnlineFoodOrderingSystem.Repository.UserRepository;
import com.example.OnlineFoodOrderingSystem.Service.UserService;
import com.example.OnlineFoodOrderingSystem.Util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService service;
	private final UserRepository userrepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		if (userrepo.findByEmail(user.getEmail()).isPresent()) {
			return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		service.createUser(user);

		return new ResponseEntity<>("Successfully registered", HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Map<String, String> body) {

		String email = body.get("email");
		String password = body.get("password");

		var userOptional = userrepo.findByEmail(email);

		if (userOptional.isEmpty()) {
			return new ResponseEntity<>("User not registered", HttpStatus.UNAUTHORIZED);
		}

		User user = userOptional.get();

		if (!passwordEncoder.matches(password, user.getPassword())) {
			return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);
		}

		String token = jwtUtil.genrateToken(email);

		return ResponseEntity.ok(Map.of("token", token, "email", user.getEmail(), "role", user.getRole()));
	}
}
