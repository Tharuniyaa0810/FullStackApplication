	package com.astrasquad.tharuniyaa.repository;
	
	import java.util.Optional;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.astrasquad.tharuniyaa.model.User;
	
	public interface UserRepository extends JpaRepository<User, Long> {
	
		 Optional<User> findByUsername(String username);
	
	    User findByUid(Long uid);
	
	    void deleteByUid(Long uid);
	
	
	}