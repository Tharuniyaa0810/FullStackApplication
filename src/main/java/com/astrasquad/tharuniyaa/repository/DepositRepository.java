package com.astrasquad.tharuniyaa.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.astrasquad.tharuniyaa.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}

