package com.astrasquad.tharuniyaa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findById(Long id);
    Optional<Wallet> findByUser(User user);
}
