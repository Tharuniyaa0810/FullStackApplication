package com.astrasquad.tharu.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.astrasquad.tharu.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // You can define custom query methods here if needed
}

