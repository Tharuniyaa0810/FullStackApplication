package com.astrasquad.tharuniyaa.repository;

import com.astrasquad.tharuniyaa.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

