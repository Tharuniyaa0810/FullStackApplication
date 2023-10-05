package com.astrasquad.tharu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astrasquad.tharu.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByUsername(String email);
}
