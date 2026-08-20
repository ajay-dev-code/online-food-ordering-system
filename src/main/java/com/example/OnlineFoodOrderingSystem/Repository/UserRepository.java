package com.example.OnlineFoodOrderingSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineFoodOrderingSystem.Entity.Role;
import com.example.OnlineFoodOrderingSystem.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 Optional<User> findByEmail(String email);

	    Optional<User> findByEmailAndPassword(String email, String password);

	    List<User> findByRole(Role role);
	   
	    boolean existsByEmail(String email);
}
