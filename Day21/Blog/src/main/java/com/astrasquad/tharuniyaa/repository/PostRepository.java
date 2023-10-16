package com.astrasquad.tharuniyaa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astrasquad.tharuniyaa.model.Post;



@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findById(Long id);
    // Add custom methods if needed
}
