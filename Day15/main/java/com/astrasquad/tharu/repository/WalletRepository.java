package com.astrasquad.tharu.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astrasquad.tharu.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    // Add custom query methods if needed
	
}

