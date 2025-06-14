package com.loginapp.auth.repo;

import com.loginapp.auth.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllByUsername(String username);
}
