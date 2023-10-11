package com.astrasquad.tharuniyaa.repository;

import com.astrasquad.tharuniyaa.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
}

