package com.astrasquad.tharuniyaa.service;

import java.util.List;

import com.astrasquad.tharuniyaa.dto.request.DepositRequest;
import com.astrasquad.tharuniyaa.dto.response.DepositResponse;

public interface DepositService {
    DepositResponse createDeposit(DepositRequest depositRequest);
    List<DepositResponse> getAllDeposits();
}


