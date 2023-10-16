package com.astrasquad.tharuniyaa.repository;

import com.astrasquad.tharuniyaa.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
