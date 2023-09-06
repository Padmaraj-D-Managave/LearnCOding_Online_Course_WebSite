package com.learnCoding.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnCoding.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	boolean existsByEmail(String email);

	Object findByEmail(String email);
	
}
