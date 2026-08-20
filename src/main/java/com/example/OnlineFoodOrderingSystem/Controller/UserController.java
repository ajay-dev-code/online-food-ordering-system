package com.example.OnlineFoodOrderingSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineFoodOrderingSystem.Entity.Role;
import com.example.OnlineFoodOrderingSystem.Entity.User;
import com.example.OnlineFoodOrderingSystem.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userservice;

	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userservice.createUser(user);
		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userservice.getAlluser();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		User user = userservice.getById(id);
		return ResponseEntity.ok(user);

	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		User updateuser = userservice.update(id, user);
		return ResponseEntity.ok(updateuser);
	}
	
	@GetMapping("/role/{role}")
	public List<User> getUsersByRole(@PathVariable Role role) {
	    return userservice.getUsersByRole(role);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		userservice.deleteUser(id);
		return ResponseEntity.ok("User delete successfully");
	}
}
