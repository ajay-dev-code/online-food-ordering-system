package com.example.OnlineFoodOrderingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrderingSystem.Entity.Role;
import com.example.OnlineFoodOrderingSystem.Entity.User;
import com.example.OnlineFoodOrderingSystem.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;

	public User createUser(User user) {
		return userrepository.save(user);
	}

	public List<User> getAlluser() {
		return userrepository.findAll();
	}

	public User getById(Long id) {
		return userrepository.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));
	}

	public User update(Long id, User user) {
		User existing = userrepository.findById(id).orElseThrow(() -> new RuntimeException("User id not found" + id));

		existing.setName(user.getName());
		existing.setEmail(user.getEmail());
		existing.setPhone(user.getPhone());
		existing.setPassword(user.getPassword());
		existing.setRole(user.getRole());

		return userrepository.save(existing);

	}

	public User findByEmail(String email) {
		if (userrepository.existsByEmail(email)) {
			throw new RuntimeException("Email already exists");
		}
		return userrepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not found with email " + email));

	}

	public User login(String email, String password) {

		return userrepository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("Invalid email or password"));
	}

	public List<User> getUsersByRole(Role role) {
		return userrepository.findByRole(role);
	}

	public void deleteUser(Long id) {
		userrepository.deleteById(id);
	}
}
