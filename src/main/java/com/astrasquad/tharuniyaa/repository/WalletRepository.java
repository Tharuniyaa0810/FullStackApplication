package com.astrasquad.tharuniyaa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astrasquad.tharuniyaa.model.Wallet;


@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    // Add custom query methods if needed
	
}