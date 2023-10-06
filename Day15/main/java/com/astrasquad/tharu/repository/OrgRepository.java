package com.astrasquad.tharu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astrasquad.tharu.model.User;

public interface OrgRepository extends JpaRepository<User, Integer> {

}
